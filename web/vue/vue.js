
//全局组件
Vue.component('global', {
    template: '<div id="divQ">全局组件{{aaa}}</div>',
    data: function () {
        this.aaa = '正在进行测试，测试全局组件里data的使用'
    }
})
//局部组件
let local = {
    template: '<div id="divJ">局部组件{{one}},{{two}},{{three}}</div>',
    props: ['one', 'two', 'three'],
    data: function () {
        this.three = '第三个参数'
    }
}
//Vue实例
new Vue({
    el: '#app-zj-data',
    data: {
        aaa: '',
        one: '第一个参数',
        two: '第二个参数',
        three: ''
    },
    components: {
        local: local
    }
})

//vue实例的写法1
new Vue({
    el: '#vdp',
    data: {},
    components: {
        myCom: {
            template: '#com',
            data: function () {
                return {
                    num: 1
                }
            },
            methods: {},
            computed: {}
        }
    }
})
//vue的实例写法2 实例 组件 模版 全部分开写
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
        myCom: mycom
    }
})

//父子组件
new Vue({
    el: '#app-fz',
    data: {},
    components: {
        fzjCom: {//在vue实例中使用fzj-com  组件
            template: '#fzj',
            data: function () {

            },
            components: {
                zzjCom: {
                    template: "#zzj",
                    data: function () {
                        return {}
                    }
                }
            }
        }
    }
})

//数据父传子
new Vue({
    el: '#app-fzdata',
    data: {
        str: '根组件传来的str'
    },
    components: {
        fzjCom: {
            template: '#fzjdata',
            props: ['str'],
            data: function () {
                return {
                    str1: 20,
                    str2: 'lai'
                }
            },
            components: {
                zzjCom: {
                    template: '#zzjdata',
                    // props:['str1','str2']
                    props: {
                        str1: {
                            type: Number,
                            default: 0,
                            required: true
                        },
                        str2: {
                            type: String,
                            default: 'ok',
                            required: true
                        }
                    }
                }
            }
        }
    }
})

new Vue({
    el: '#app-fz',
    components: {
        fzjCom: {
            template: '#fzj',
            data: function () {
                return {
                    reStr: ''
                }
            },
            components: {
                zzjCom: {
                    template: '#zzj',
                    data: function () {
                        return {
                            str: ''
                        }
                    },
                    methods: {
                        send() {
                            this.$emit('sendstr', this.str)
                        }
                    }
                }
            },
            methods: {
                jieshou(shou) {
                    this.reStr = show
                }
            }
        }
    }
})