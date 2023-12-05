var NexT = window.NexT || {}, CONFIG = {
    root: "",
    scheme: "Pisces",
    version: "1.0.2",
    sidebar: {position: "right", display: "always", offset: 52, b2t: !1, scrollpercent: !1, onmobile: !1},
    fancybox: !1,
    tabs: !0,
    motion: {
        enable: !1,
        async: !1,
        transition: {
            post_block: "fadeIn",
            post_header: "slideDownIn",
            post_body: "slideDownIn",
            coll_header: "slideLeftIn",
            sidebar: "slideUpIn"
        }
    },
    since: "2/9/2014 11:30:00",
    site: {title: "", subtitle: "", author: ""},
    duoshuo: {userId: "0", author: "博主"},
    algolia: {
        applicationID: "",
        apiKey: "",
        indexName: "",
        hits: {per_page: 10},
        labels: {
            input_placeholder: "Search for Posts",
            hits_empty: "We didn't find any results for the search: ${query}",
            hits_stats: "${hits} results found in ${time} ms"
        }
    },
    leancloud: {enable: !0, appID: "hRDdibVwWhuIGMhhzAMXiFYG-MdYXbMMI", appKey: "DB8u9iGG8iMTGAGOKz28lIer"},
    favicon: {
        visibilitychange: !0,
        narmal: "/favicon.ico",
        hidden: "/failure.ico",
        show_text: "(/≧▽≦/)咦！又好了！",
        hide_text: "(●—●)喔哟，崩溃啦！"
    }
}