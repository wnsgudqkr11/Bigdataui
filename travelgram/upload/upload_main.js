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
