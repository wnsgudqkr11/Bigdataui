// 지도와 타일 레이어를 초기화합니다.
const map = L.map('map').setView([37.5665, 126.9780], 13); // 서울 시청 좌표로 초기 위치 설정

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,
}).addTo(map);

// 출발지와 목적지 마커를 저장할 변수
let startMarker, endMarker;

// 경로를 저장할 변수
let route;

// 클릭 이벤트 리스너를 추가하여 출발지와 목적지를 설정합니다.
map.on('click', function(e) {
    if (!startMarker) {
        // 출발지가 설정되지 않은 경우 출발지 마커를 추가합니다.
        startMarker = L.marker(e.latlng, { draggable: true }).addTo(map)
            .bindPopup('출발지').openPopup();
    } else if (!endMarker) {
        // 목적지가 설정되지 않은 경우 목적지 마커를 추가합니다.
        endMarker = L.marker(e.latlng, { draggable: true }).addTo(map)
            .bindPopup('목적지').openPopup();
        findRoute(); // 출발지와 목적지가 설정되면 경로를 찾습니다.
    }
});

// OSRM API를 사용하여 최적 경로를 찾는 함수
function findRoute() {
    if (!startMarker || !endMarker) return; // 출발지와 목적지가 모두 설정되어야 합니다.

    const start = startMarker.getLatLng();
    const end = endMarker.getLatLng();

    // OSRM API를 사용하여 경로를 요청합니다.
    const url = `https://router.project-osrm.org/route/v1/driving/${start.lng},${start.lat};${end.lng},${end.lat}?geometries=geojson&overview=full`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            const routeCoordinates = data.routes[0].geometry.coordinates;
            const routeLatLngs = routeCoordinates.map(coord => [coord[1], coord[0]]); // 위도와 경도를 Leaflet 형식에 맞게 변환합니다.

            // 기존 경로가 있으면 제거합니다.
            if (route) {
                map.removeLayer(route);
            }

            // 새로운 경로를 그립니다.
            route = L.polyline(routeLatLngs, { color: 'blue' }).addTo(map);
            map.fitBounds(route.getBounds()); // 경로를 지도의 중앙에 맞춥니다.
        })
        .catch(error => {
            console.error('경로 찾기 에러:', error);
        });
}

// 경로가 설정된 경우 출발지나 목적지 마커를 드래그하여 경로를 업데이트합니다.
map.on('dragend', function(e) {
    if (e.target === startMarker || e.target === endMarker) {
        findRoute(); // 마커가 이동될 때마다 경로를 다시 찾습니다.
    }
});