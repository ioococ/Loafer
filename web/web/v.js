var array = ['#ffa065', '#97ff6e', '#6efff0', '#79b1ff', '#e88dff', '#9694ff'];
function clr() {
    r = 0,
    mP = Math.PI*2,
    mc = Math.cos,
    mr = Math.random,
    r-=mP/-50
    x = '#'+(mc(r)*127+128<<16 | mc(r+mP/3)*127+128<<8 | mc(r+mP/3*2)*127+128).toString(16)
    return x
}

let img0 = {
    template: '#img0'
}
let img1 = {
    template: '#img1'
}
let img2 = {
    template: '#img2'
}
let img3 = {
    template: '#img3'
}
let img4 = {
    template: '#img4'
}
let img5 = {
    template: '#img5'
}
new Vue({
    el: '#vdc',
    data: {
        currentName: 'img0',
        styleObject: {
            border: '3px solid ' + clr(),
            'border-radius': '3px',
        }
    },
    components: {
        img0,
        img1,
        img2,
        img3,
        img4,
        img5
    },
    methods: {
        a: function() {
            this.currentName = 'img' + Math.floor(Math.random() * 5 + 1)
            r = 0,
            mP = Math.PI*2,
            mc = Math.cos,
            mr = m.random,
            r-=mP/-50
            // alert(clr())
        }
    }
})