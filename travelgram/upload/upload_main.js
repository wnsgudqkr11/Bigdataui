// ============ 변수 설정 ============
const fileInput = document.getElementById("fileUpload");
const previewImage = document.getElementById("previewImage");
const uploadSection = document.getElementById("upload");
const previewSection = document.getElementById("preview");
const backBtn = document.getElementById("backBtn");

// ============ 사진 업로드 ============
fileInput.addEventListener("change", function () {
    const file = this.files[0];

    if (file) {
        const reader = new FileReader();

        reader.onload = function (e) {
            previewImage.src = e.target.result;
            uploadSection.style.display = "none";
            previewSection.style.display = "flex";
        };

        // 미리보기 지도 강제 리사이즈
        setTimeout(() => {
            previewMap.invalidateSize();
        }, 200);


        reader.readAsDataURL(file);
    }
});

// ============ 뒤로가기 ============
backBtn.addEventListener("click", function () {
    // preview 화면 숨기기
    previewSection.style.display = "none";

    // upload 화면 다시 보이게
    uploadSection.style.display = "flex";

    // ✅ 파일 input 초기화 (같은 파일 다시 선택 가능하게)
    fileInput.value = "";

    // ✅ 이미지 미리보기 초기화
    previewImage.src = "";
});




// ================== 지도 ====================
// 🔹 미리보기 지도 (작은 지도)
const previewMap = L.map('map-preview', {
    zoomControl: false,
    attributionControl: false
}).setView([37.5665, 126.9780], 12);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19
}).addTo(previewMap);

// 🔹 전체 지도 (모달 내부)
const fullMap = L.map('map-fullscreen').setView([37.5665, 126.9780], 13);

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,
    attribution: '© OpenStreetMap'
}).addTo(fullMap);

// 🔹 마커와 경로 관련 변수
let startMarker, endMarker;
let carRoute, walkRoute;

// 🔹 모달 열기
document.getElementById('map-preview-container').addEventListener('click', () => {
    document.getElementById('map-modal').style.display = 'block';
    fullMap.invalidateSize(); // 모달 열릴 때 지도 리사이즈
});

// 🔹 모달 닫기
document.getElementById('close-map').addEventListener('click', () => {
    document.getElementById('map-modal').style.display = 'none';
});

// 🔹 주소 → 좌표 변환 (Nominatim API)
function geocode(address, callback) {
    fetch(`https://nominatim.openstreetmap.org/search?format=json&q=${encodeURIComponent(address)}`)
        .then(response => response.json())
        .then(data => {
            if (data && data.length > 0) {
                callback(data[0].lat, data[0].lon);
            } else {
                alert('주소를 찾을 수 없습니다.');
            }
        })
        .catch(error => {
            console.error('지오코딩 에러:', error);
        });
}

// 🔹 사용자가 출발지/도착지 입력 후 경로 찾기
function findRoute() {
    const startAddress = document.getElementById('start').value;
    const endAddress = document.getElementById('end').value;

    if (!startAddress || !endAddress) {
        alert('출발지와 목적지 주소를 모두 입력하세요.');
        return;
    }

    document.getElementById('info').innerHTML = ''; // 이전 정보 초기화

    geocode(startAddress, (startLat, startLon) => {
        const startLatLng = new L.LatLng(startLat, startLon);

        if (startMarker) fullMap.removeLayer(startMarker);
        startMarker = L.marker(startLatLng, { draggable: true }).addTo(fullMap).bindPopup('출발지').openPopup();

        geocode(endAddress, (endLat, endLon) => {
            const endLatLng = new L.LatLng(endLat, endLon);

            if (endMarker) fullMap.removeLayer(endMarker);
            endMarker = L.marker(endLatLng, { draggable: true }).addTo(fullMap).bindPopup('목적지').openPopup();

            // 경로 계산
            calculateRoute(startLatLng, endLatLng, 'driving', 'blue', '자동차');
            calculateRoute(startLatLng, endLatLng, 'foot', 'green', '도보');
        });
    });
}

// 🔹 OSRM API로 경로 계산 후 지도에 표시
function calculateRoute(startLatLng, endLatLng, mode, color, label) {
    const url = `https://router.project-osrm.org/route/v1/${mode}/${startLatLng.lng},${startLatLng.lat};${endLatLng.lng},${endLatLng.lat}?geometries=geojson&overview=full`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            if (data.code !== 'Ok') {
                alert(`${label} 경로를 찾을 수 없습니다.`);
                return;
            }

            const routeCoordinates = data.routes[0].geometry.coordinates;
            const routeLatLngs = routeCoordinates.map(coord => [coord[1], coord[0]]);
            const duration = data.routes[0].duration / 60;

            if (mode === 'driving' && carRoute) fullMap.removeLayer(carRoute);
            if (mode === 'foot' && walkRoute) fullMap.removeLayer(walkRoute);

            const route = L.polyline(routeLatLngs, { color: color, weight: 5, opacity: 0.7 }).addTo(fullMap);
            fullMap.fitBounds(route.getBounds());

            if (mode === 'driving') {
                carRoute = route;
                carRoute.options.duration = duration;
                document.getElementById('info').innerHTML += `<p>🚗 자동차 경로 소요 시간: ${duration.toFixed(1)} 분</p>`;
            } else if (mode === 'foot') {
                walkRoute = route;
                walkRoute.options.duration = duration;
                document.getElementById('info').innerHTML += `<p>🚶 도보 경로 소요 시간: ${duration.toFixed(1)} 분</p>`;
            }

            // 두 경로 모두 구해졌으면 비교 출력
            if (carRoute && walkRoute) {
                const carTime = carRoute.options.duration;
                const walkTime = walkRoute.options.duration;
                const comparison = `🆚 경로 비교: 자동차 ${carTime.toFixed(1)}분 / 도보 ${walkTime.toFixed(1)}분`;
                document.getElementById('info').innerHTML += `<p>${comparison}</p>`;
            }
        })
        .catch(error => {
            console.error(`${label} 경로 찾기 에러:`, error);
        });
}
