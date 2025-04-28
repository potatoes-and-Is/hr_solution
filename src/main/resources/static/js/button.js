document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('openPopup').addEventListener('click', function() {
        openCenteredPopup('/author/popup', '직원 등록', 800, 600);
    });
});

document.addEventListener('click', function(e) {
    if(e.target && e.target.classList.contains('update-btn')) {
        const employeeId = e.target.dataset.id;
        openCenteredPopup(`/author/employee/update/${employeeId}`, '직원 수정', 800, 600);
    }
});
