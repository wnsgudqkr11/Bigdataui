// 지도와 타일 레이어를 초기화합니다.
const map = L.map('map').setView([37.5665, 126.9780], 13); // 서울 시청 좌표로 초기 위치 설정

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,
    attribution: '© OpenStreetMap'
}).addTo(map);

// 출발지와 목적지 마커를 저장할 변수
let startMarker, endMarker;

// 경로를 저장할 변수
let carRoute, walkRoute;

// 주소를 좌표로 변환하는 함수 (Nominatim API 사용)
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

// 사용자가 주소를 입력하고 경로를 찾는 함수
function findRoute() {
    const startAddress = document.getElementById('start').value;
    const endAddress = document.getElementById('end').value;

    if (!startAddress || !endAddress) {
        alert('출발지와 목적지 주소를 모두 입력하세요.');
        return;
    }

    // 출발지 좌표 찾기
    geocode(startAddress, (startLat, startLon) => {
        const startLatLng = new L.LatLng(startLat, startLon);
        
        // 출발지 마커를 추가
        if (startMarker) {
            map.removeLayer(startMarker);
        }
        startMarker = L.marker(startLatLng, { draggable: true }).addTo(map).bindPopup('출발지').openPopup();

        // 목적지 좌표 찾기
        geocode(endAddress, (endLat, endLon) => {
            const endLatLng = new L.LatLng(endLat, endLon);

            // 목적지 마커를 추가
            if (endMarker) {
                map.removeLayer(endMarker);
            }
            endMarker = L.marker(endLatLng, { draggable: true }).addTo(map).bindPopup('목적지').openPopup();

            // 자동차 경로 계산 및 표시
            calculateRoute(startLatLng, endLatLng, 'driving', 'blue', '자동차');
            // 도보 경로 계산 및 표시
            calculateRoute(startLatLng, endLatLng, 'foot', 'green', '도보');
        });
    });
}

// 출발지와 목적지 좌표를 기반으로 최적 경로를 계산하는 함수 (OSRM API 사용)
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
            const routeLatLngs = routeCoordinates.map(coord => [coord[1], coord[0]]); // 위도와 경도를 Leaflet 형식에 맞게 변환합니다.
            const duration = data.routes[0].duration / 60; // 소요 시간을 분 단위로 변환

            // 기존 경로가 있으면 제거합니다.
            if (mode === 'driving' && carRoute) {
                map.removeLayer(carRoute);
            } else if (mode === 'foot' && walkRoute) {
                map.removeLayer(walkRoute);
            }

            // 새로운 경로를 그립니다.
            const route = L.polyline(routeLatLngs, { color: color, weight: 5, opacity: 0.7 }).addTo(map);
            map.fitBounds(route.getBounds()); // 경로를 지도의 중앙에 맞춥니다.

            // 경로를 저장합니다.
            if (mode === 'driving') {
                carRoute = route;
                carRoute.options.duration = duration; // 자동차 경로 소요 시간 저장
                document.getElementById('info').innerHTML += `<p>자동차 경로 소요 시간: ${duration.toFixed(1)} 분</p>`;
            } else if (mode === 'foot') {
                walkRoute = route;
                walkRoute.options.duration = duration; // 도보 경로 소요 시간 저장
                document.getElementById('info').innerHTML += `<p>도보 경로 소요 시간: ${duration.toFixed(1)} 분</p>`;
            }

            // 자동차와 도보 경로 소요 시간을 비교합니다.
            if (carRoute && walkRoute) {
                const carTime = carRoute.options.duration;
                const walkTime = walkRoute.options.duration;
                const comparisonText = `자동차와 도보 경로 소요 시간 비교: 자동차 - ${carTime.toFixed(1)} 분, 도보 - ${walkTime.toFixed(1)} 분`;
                document.getElementById('info').innerHTML += `<p>${comparisonText}</p>`;
            }
        })
        .catch(error => {
            console.error(`${label} 경로 찾기 에러:`, error);
        });
}

// 마커가 드래그될 때마다 경로를 다시 계산하는 이벤트 리스너
map.on('dragend', function(e) {
    if (e.target === startMarker || e.target === endMarker) {
        calculateRoute(startMarker.getLatLng(), endMarker.getLatLng(), 'driving', 'blue', '자동차');
        calculateRoute(startMarker.getLatLng(), endMarker.getLatLng(), 'foot', 'green', '도보');
    }
});