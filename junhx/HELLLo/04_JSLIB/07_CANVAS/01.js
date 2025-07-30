// canvas 요소를 가져오고 2D 그리기 컨텍스트를 설정합니다.
const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');

// 그리기 상태를 나타내는 변수와 색상 및 크기 설정을 초기화합니다.
let painting = false; // 그리기 상태를 추적하는 변수
let color = document.getElementById('color').value; // 기본 그리기 색상
let size = document.getElementById('size').value; // 기본 그리기 크기

// 마우스 이벤트 리스너를 추가하여 그리기 동작을 설정합니다.
canvas.addEventListener('mousedown', startPosition); // 마우스를 누를 때 시작
canvas.addEventListener('mouseup', endPosition); // 마우스를 뗄 때 종료
canvas.addEventListener('mousemove', draw); // 마우스를 움직일 때 그리기

// 색상 선택기가 변경될 때마다 색상을 업데이트합니다.
document.getElementById('color').addEventListener('change', (e) => color = e.target.value);

// 크기 슬라이더가 변경될 때마다 브러시 크기를 업데이트합니다.
document.getElementById('size').addEventListener('input', (e) => size = e.target.value);

// 그리기를 시작하는 함수입니다.
function startPosition(e) {
    painting = true; // 그리기 상태를 활성화합니다.
    draw(e); // 그리기 시작점에서 선을 그립니다.
}

// 그리기를 종료하는 함수입니다.
function endPosition() {
    painting = false; // 그리기 상태를 비활성화합니다.
    ctx.beginPath(); // 새로운 경로를 시작하여 이전 경로를 초기화합니다.
}

// 실제로 그리기를 수행하는 함수입니다.
function draw(e) {
    if (!painting) return; // 만약 그리기 상태가 아니면 함수를 종료합니다.

    // 그리기 속성을 설정합니다.
    ctx.lineWidth = size; // 브러시 크기를 설정합니다.
    ctx.lineCap = 'round'; // 선의 끝 모양을 둥글게 설정합니다.
    ctx.strokeStyle = color; // 선의 색상을 설정합니다.

    // 현재 위치로 선을 그립니다.
    ctx.lineTo(e.clientX - canvas.offsetLeft, e.clientY - canvas.offsetTop);
    ctx.stroke(); // 그린 선을 화면에 나타냅니다.

    // 새로운 경로를 시작하여 현재 위치에서 새로운 선을 그리도록 준비합니다.
    ctx.beginPath();
    ctx.moveTo(e.clientX - canvas.offsetLeft, e.clientY - canvas.offsetTop);
}

// 캔버스를 지우는 함수입니다.
function clearCanvas() {
    ctx.clearRect(0, 0, canvas.width, canvas.height); // 캔버스 전체를 지웁니다.
}


