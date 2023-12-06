let home = {
    template: '#home',
}
let news = {
    template: '#news',
}
let cars = {
    template: '#cars',
}
let cars_mpv = {
    template: '#cars_mpv',
}
let cars_suv = {
    template: '#cars_suv',
}
let cars_car = {
    template: '#cars_car',
}
let cars_car_bmw = {
    template: '#cars_car_bmw',
}
let cars_car_lexus ={
    template: '#cars_car_lexus',
}
let route = new VueRouter({
    routes: [
        {
            path: '/home',
            component: home
        }, {
            path: '/news',
            component: news
        }, {
            path: '/cars',
            component: cars,
            children: [{
                path: '/cars/cars_mpv',
                component: cars_mpv
            }, {
                path: '/cars/cars_suv',
                component: cars_suv
            }, {
                path: '/cars/cars_car',
                component: cars_car,
                children: [{
                    path: '/cars/cars_car_bmw',
                    component: cars_car_bmw
                },{
                    path: '/cars/cars_car_lexus',
                    component: cars_car_lexus
                }]
            }]
        }
    ]
})
new Vue({
    el: '#vrc',
    components: {
        home, news, cars
    },
    router: route

})

let index = {
    template: '#index',
}
let newss = {
    template: '#newss',
}
let rout = new VueRouter({
    routes: [
        {
            path: '/index',
            component: index
        }, {
            path: '/newss/:date/',
            component: newss
        }
    ]
})
new Vue({
    el: '#vrr',
    components: {
        index, newss
    },
    router: rout
})