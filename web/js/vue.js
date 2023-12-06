new Vue({
    el: '#exp',
    data: {
        ok: true,
        message: 'Happy New Year !',
        id: 1
    }
})
new Vue({
    el: '#voc',
    data: {
        msg: '是只执行一次吗'
    }
})
new Vue({
    el: '#vbd',
    data: {
        url: 'https://www.baidu.com'
    }
})
new Vue({
    el: '#vif',
    data: {
        ok: true,
        jump: true
    }
})
new Vue({
    el: '#ves',
    data: {
        ok: false,
        jump: false
    }
})
new Vue({
    el: '#vef',
    data: {
        type: '大风'
    }
})
new Vue({
    el: '#vfr',
    data: {
        sites: ["ZhangSan", "LiSi", "WangWu"]
    }
})
new Vue({
    el: '#vfs',
    data: {
        names: [{
            name: "ZhangSan"
        }, {
            name: "LiSi"
        }, {
            name: "WangWu"
        }]
    }
})
new Vue({
    el: '#vfn',
    data: {
        obj: {
            name: 'ZhangSan',
            sex: 'male',
            age: 18
        }
    }
})
new Vue({
    el: '#vkv',
    data: {
        obj: {
            name: 'ZhangSan',
            sex: 'male',
            age: 18
        }
    }
})
new Vue({
    el: '#v',
    data: {
        sites: ['ZhangSan', 'LiSi', 'WangWu']
    }
})
new Vue({
    el: '#vt',
    data: {
        Lumberg: {
            name: 'ZhangSan',
            sex: 'male',
            age: 18
        }
    }
})
new Vue({
    el: '#vfi'
})
new Vue({
    el: '#vwh',
    data: {
        price: 1,
        num: 1,
        total: 1
    },
    watch: {
        price: function () {
            this.total = this.price * this.num
        },
        num: function () {
            this.total = this.price * this.num
        }
    }
})
let pm = new Vue({
    el: '#vwa',
    data: {
        price: 1,
        num: 1,
        total: 1
    }
});
pm.$watch('price', function () {
    pm.total = pm.price * pm.num
})
pm.$watch('num', function () {
    pm.total = pm.price * pm.num
})
new Vue({
    el: '#vwe',
    data: {
        counter: 0
    }
})
new Vue({
    el: '#vws',
    data: {
        counter: 0
    }
})
new Vue({
    el: '#vwm',
    methods: {
        alertW: function (event) {
            alert("Hello")
        }
    }
})
new Vue({
    el: '#vce',
    data: {
        OldStr: 'Happy'
    },
    computed: {
        NewStr: function () {
            return this.OldStr.toUpperCase();
        }
    }
})
new Vue({
    el: '#vcm',
    data: {
        OldStr: 'Happy'
    },
    computed: {
        CNewStr: function () {
            return this.OldStr.toUpperCase();
        }
    },
    methods: {
        MNewStr: function () {
            return this.OldStr.toUpperCase();
        }
    }
})
new Vue({
    el: '#vty',
    data: {
        isActive: true,
        // 优先级高低    红的比绿的高 只有把红的false  绿的才能出来
        hasError: false
    }
})
new Vue({
    el: '#vtj',
    data: {
        isActive: true,
        error: {
            value: false,
            type: 'fatal'
        }
    },
    computed: {
        classObject: function () {
            return {
                base: true,
                //真真得真
                active: this.isActive && !this.error.value,
                'text-danger': this.error.value && this.error.fatal == "fatal"
            }
        }
    }
})
new Vue({
    el: '#vtt',
    data: {
        isActive: true,
        activeClass: 'active',
        errorClass: 'text-danger',
        warningClass: 'text-warning'
    }
})
new Vue({
    el: '#vti',
    data: {
        activeColor: '#D3D3FF',
        fontSize: 100
    }
})
new Vue({
    el: '#vto',
    data: {
        styleObject: {
            color: '#D3D3FF',
            fontSize: '100px',
            border: '1px solid red'
        }
    }
})
new Vue({
    el: '#vsg',
    data: {
        baseStyles: {
            color: '#D3D3FF',
            fontSize: '100px',
        },
        overridingStyles: {
            color: '#D3D3FF',
            fontSize: '100px',
            'font-weight': 'bold',
        }
    }
})
new Vue({
    el: '#vfc',
    data: {
        vft: '虎斑霞绮',
        vfa: '虎头蛇尾，虎踞龙盘，虎口拔牙'
    }
})
new Vue({
    el: '#vro',
    data: {
        picked: ''
    }
})
new Vue({
    el: '#vso',
    data: {
        selected: ''
    }
})
Vue.component('gcCom', {
    template: '<div>' +
        '<p>全局组件：新的一年里，天空中写下的满是祝福</p>' +
        '</div>'
})
new Vue({
    el: '#vgc'
})
let child = {
    template: '<div>' +
        '<p>局部组件：新的一年里，天空中写下的满是祝福</p>' +
        '</div>'
}
let plc1 = new Vue({
    el: '#vlc',
    components: {
        'lc-com': child
    }
})
let plc2 = new Vue({
    el: '#vlt',
    components: {
        'lc-com': child
    }
})

//全局组件
Vue.component('global', {
    template: '<div id="divQ">全局组件</div>',
    data: function () {
        this.aaa = '正在进行全局测试'
    }
})
//局部组件
let local = {
    template: '<div id="divJ">局部组件{{one}},{{two}}{{three}}</div>',
    props: ['one', 'two', 'three'],
    data: function () {
        this.three = '正在进行局部测试'
    }
}
//Vue实例
new Vue({
    el: '#vgl',
    data: {
        app: '',
        one: '第一个参数',
        two: '第二个参数',
        three: '',
    },
    components: {
        local: local
    }
})
let decoupling = {
    template: '#com',
    data: function () {
        return {
            num: 1
        }
    }
}
let mycom = {
    template: '#com',
    data: function () {
        return {
            num: 1
        }
    }
}
new Vue({
    el: '#vdp',
    data: {},
    components: {
        myCom: mycom,
        decoupling: decoupling
    }
})