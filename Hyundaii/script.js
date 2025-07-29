function openModal() {
  document.getElementById('evModal').style.display = 'block';
}

function closeModal() {
  document.getElementById('evModal').style.display = 'none';
}

// 배경 클릭 시 닫기
window.onclick = function(event) {
  const modal = document.getElementById('evModal');
  if (event.target === modal) {
    modal.style.display = 'none';
  }
}



// ========mid =======

  const ctx = document.getElementById('statusChart').getContext('2d');

  const chartData = {
    ev: {
      labels: ['공고', '접수', '출고'],
      data: [9174, 4115, 3407],
      remain: '5,767',
      score: '(5,059)'
    },
    hydrogen: {
      labels: ['공고', '접수', '출고'],
      data: [144, 86, 46],
      remain: '98',
      score: '(58)'
    },
    bike: {
      labels: ['공고', '접수', '출고'],
      data: [1000, 73, 64],
      remain: '936',
      score: '(927)'
    }
  };

  const chart = new Chart(ctx, {
    type: 'bar',
    data: {
      labels: chartData.ev.labels,
      datasets: [{
        label: '대수',
        data: chartData.ev.data,
        backgroundColor: ['#eac7cf', '#996633', '#003366']
      }]
    },
    options: {
      plugins: {
        legend: { display: false }
      },
      scales: {
        y: {
          beginAtZero: true,
          ticks: { stepSize: 2000 }
        }
      }
    }
  });

  function updateChart(type) {
    chart.data.datasets[0].data = chartData[type].data;
    chart.update();

    document.getElementById('remainCount').textContent = chartData[type].remain;
    document.getElementById('score').textContent = chartData[type].score;

    // 탭 버튼 스타일 업데이트
    document.querySelectorAll('.tabs button').forEach(btn => btn.classList.remove('active'));
    const index = { ev: 0, hydrogen: 1, bike: 2 }[type];
    document.querySelectorAll('.tabs button')[index].classList.add('active');
  }
