document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('openPopup').addEventListener('click', function() {
        const w = 800;
        const h = 600;

        const left = (window.screen.width / 2) - (w / 2);
        const top = (window.screen.height / 2) - (h / 2);

        window.open('/author/popup', 'CenteredPopup',
            `width=${w},height=${h},left=${left},top=${top},scrollbars=yes,resizable=yes`);
    });
});