"mousemove mouseup mousedown click scroll touchmove touchstart touchend touchcancel".split(" ").forEach(type => {
    window.addEventListener(type, e => {
        if (window.leaker) {
            window.leaker[window.leaker.length] = e;
        } else {
            window.leaker = []
        }
    })
})