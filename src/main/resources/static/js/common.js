function openCenteredPopup(url, title, width = 800, height = 600) {
    const dualScreenLeft = window.screenLeft !== undefined ? window.screenLeft : window.screenX;
    const dualScreenTop = window.screenTop !== undefined ? window.screenTop : window.screenY;

    const browserWidth = window.innerWidth || document.documentElement.clientWidth || screen.width;
    const browserHeight = window.innerHeight || document.documentElement.clientHeight || screen.height;

    const left = dualScreenLeft + (browserWidth - width) / 2;
    const top = dualScreenTop + (browserHeight - height) / 2;

    window.open(url, title,
        `scrollbars=yes,resizable=yes,width=${width},height=${height},top=${top},left=${left}`);
}



