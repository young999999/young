(function(e){function n(n){for(var o,r,s=n[0],u=n[1],c=n[2],l=0,p=[];l<s.length;l++)r=s[l],a[r]&&p.push(a[r][0]),a[r]=0;for(o in u)Object.prototype.hasOwnProperty.call(u,o)&&(e[o]=u[o]);d&&d(n);while(p.length)p.shift()();return i.push.apply(i,c||[]),t()}function t(){for(var e,n=0;n<i.length;n++){for(var t=i[n],o=!0,r=1;r<t.length;r++){var u=t[r];0!==a[u]&&(o=!1)}o&&(i.splice(n--,1),e=s(s.s=t[0]))}return e}var o={},a={index:0},i=[];function r(e){return s.p+"static/js/"+({"pages-index-index":"pages-index-index","pages-news-news":"pages-news-news","pages-test-test":"pages-test-test"}[e]||e)+"."+{"pages-index-index":"7c7d636b","pages-news-news":"b44bf08e","pages-test-test":"a80c8631"}[e]+".js"}function s(n){if(o[n])return o[n].exports;var t=o[n]={i:n,l:!1,exports:{}};return e[n].call(t.exports,t,t.exports,s),t.l=!0,t.exports}s.e=function(e){var n=[],t=a[e];if(0!==t)if(t)n.push(t[2]);else{var o=new Promise(function(n,o){t=a[e]=[n,o]});n.push(t[2]=o);var i,u=document.createElement("script");u.charset="utf-8",u.timeout=120,s.nc&&u.setAttribute("nonce",s.nc),u.src=r(e),i=function(n){u.onerror=u.onload=null,clearTimeout(c);var t=a[e];if(0!==t){if(t){var o=n&&("load"===n.type?"missing":n.type),i=n&&n.target&&n.target.src,r=new Error("Loading chunk "+e+" failed.\n("+o+": "+i+")");r.type=o,r.request=i,t[1](r)}a[e]=void 0}};var c=setTimeout(function(){i({type:"timeout",target:u})},12e4);u.onerror=u.onload=i,document.head.appendChild(u)}return Promise.all(n)},s.m=e,s.c=o,s.d=function(e,n,t){s.o(e,n)||Object.defineProperty(e,n,{enumerable:!0,get:t})},s.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},s.t=function(e,n){if(1&n&&(e=s(e)),8&n)return e;if(4&n&&"object"===typeof e&&e&&e.__esModule)return e;var t=Object.create(null);if(s.r(t),Object.defineProperty(t,"default",{enumerable:!0,value:e}),2&n&&"string"!=typeof e)for(var o in e)s.d(t,o,function(n){return e[n]}.bind(null,o));return t},s.n=function(e){var n=e&&e.__esModule?function(){return e["default"]}:function(){return e};return s.d(n,"a",n),n},s.o=function(e,n){return Object.prototype.hasOwnProperty.call(e,n)},s.p="/",s.oe=function(e){throw console.error(e),e};var u=window["webpackJsonp"]=window["webpackJsonp"]||[],c=u.push.bind(u);u.push=n,u=u.slice();for(var l=0;l<u.length;l++)n(u[l]);var d=c;i.push([0,"chunk-vendors"]),t()})({0:function(e,n,t){e.exports=t("c5d7")},"19b1":function(e,n,t){"use strict";Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var o={onLaunch:function(){console.log("App Launch")},onShow:function(){console.log("App Show")},onHide:function(){console.log("App Hide")}};n.default=o},2452:function(e,n,t){"use strict";(function(e){var n=t("288e"),o=n(t("5176")),a=n(t("e143"));e["____2B0811E____"]=!0,delete e["____2B0811E____"],e.__uniConfig={tabBar:{color:"#000000",selectedColor:"#0000FF",borderStyle:"black",backgroundColor:"#FF8C00",list:[{pagePath:"pages/index/index",text:"首页",iconPath:"static/home.png",selectedIconPath:"static/home1.png",redDot:!1,badge:""},{pagePath:"pages/news/news",text:"新闻",iconPath:"static/news.png",selectedIconPath:"static/news1.png",redDot:!1,badge:""},{pagePath:"pages/test/test",text:"登录",iconPath:"static/login.png",selectedIconPath:"static/login1.png",redDot:!1,badge:""}]},globalStyle:{navigationBarTextStyle:"black",navigationBarTitleText:"uni-app",navigationBarBackgroundColor:"#F8F8F8",backgroundColor:"#F8F8F8"},condition:{current:0,list:[{name:"",path:"",query:""}]}},e.__uniConfig.router={mode:"hash",base:"/"},e.__uniConfig["async"]={loading:"AsyncLoading",error:"AsyncError",delay:200,timeout:3e3},e.__uniConfig.debug=!1,e.__uniConfig.networkTimeout={request:6e3,connectSocket:6e3,uploadFile:6e3,downloadFile:6e3},e.__uniConfig.sdkConfigs={},e.__uniConfig.qqMapKey="XVXBZ-NDMC4-JOGUS-XGIEE-QVHDZ-AMFV2",e.__uniConfig.nvue={"flex-direction":"column"},a.default.component("pages-index-index",function(e){var n={component:t.e("pages-index-index").then(function(){return e(t("942b"))}.bind(null,t)).catch(t.oe),delay:__uniConfig["async"].delay,timeout:__uniConfig["async"].timeout};return __uniConfig["async"]["loading"]&&(n.loading={name:"SystemAsyncLoading",render:function(e){return e(__uniConfig["async"]["loading"])}}),__uniConfig["async"]["error"]&&(n.error={name:"SystemAsyncError",render:function(e){return e(__uniConfig["async"]["error"])}}),n}),a.default.component("pages-news-news",function(e){var n={component:t.e("pages-news-news").then(function(){return e(t("681d"))}.bind(null,t)).catch(t.oe),delay:__uniConfig["async"].delay,timeout:__uniConfig["async"].timeout};return __uniConfig["async"]["loading"]&&(n.loading={name:"SystemAsyncLoading",render:function(e){return e(__uniConfig["async"]["loading"])}}),__uniConfig["async"]["error"]&&(n.error={name:"SystemAsyncError",render:function(e){return e(__uniConfig["async"]["error"])}}),n}),a.default.component("pages-test-test",function(e){var n={component:t.e("pages-test-test").then(function(){return e(t("ed04"))}.bind(null,t)).catch(t.oe),delay:__uniConfig["async"].delay,timeout:__uniConfig["async"].timeout};return __uniConfig["async"]["loading"]&&(n.loading={name:"SystemAsyncLoading",render:function(e){return e(__uniConfig["async"]["loading"])}}),__uniConfig["async"]["error"]&&(n.error={name:"SystemAsyncError",render:function(e){return e(__uniConfig["async"]["error"])}}),n}),e.__uniRoutes=[{path:"/",alias:"/pages/index/index",component:{render:function(e){return e("Page",{props:(0,o.default)({isQuit:!0,isEntry:!0,isTabBar:!0,tabBarIndex:0},__uniConfig.globalStyle,{navigationBarTitleText:"首页"})},[e("pages-index-index",{slot:"page"})])}},meta:{id:1,name:"pages-index-index",isNVue:!1,pagePath:"pages/index/index",isQuit:!0,isEntry:!0,isTabBar:!0,tabBarIndex:0,windowTop:0}},{path:"/pages/news/news",component:{render:function(e){return e("Page",{props:(0,o.default)({isQuit:!0,isTabBar:!0,tabBarIndex:1},__uniConfig.globalStyle,{navigationBarTitleText:"新闻页"})},[e("pages-news-news",{slot:"page"})])}},meta:{id:2,name:"pages-news-news",isNVue:!1,pagePath:"pages/news/news",isQuit:!0,isTabBar:!0,tabBarIndex:1,windowTop:0}},{path:"/pages/test/test",component:{render:function(e){return e("Page",{props:(0,o.default)({isQuit:!0,isTabBar:!0,tabBarIndex:2},__uniConfig.globalStyle,{navigationBarTitleText:"测试页"})},[e("pages-test-test",{slot:"page"})])}},meta:{id:3,name:"pages-test-test",isNVue:!1,pagePath:"pages/test/test",isQuit:!0,isTabBar:!0,tabBarIndex:2,windowTop:0}},{path:"/preview-image",component:{render:function(e){return e("Page",{props:{navigationStyle:"custom"}},[e("system-preview-image",{slot:"page"})])}},meta:{name:"preview-image",pagePath:"/preview-image"}},{path:"/choose-location",component:{render:function(e){return e("Page",{props:{navigationStyle:"custom"}},[e("system-choose-location",{slot:"page"})])}},meta:{name:"choose-location",pagePath:"/choose-location"}},{path:"/open-location",component:{render:function(e){return e("Page",{props:{navigationStyle:"custom"}},[e("system-open-location",{slot:"page"})])}},meta:{name:"open-location",pagePath:"/open-location"}}]}).call(this,t("c8ba"))},"27c4":function(e,n,t){"use strict";var o=t("c0b5"),a=t.n(o);a.a},6913:function(e,n,t){"use strict";Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var o={appid:"__UNI__2B0811E"};n.default=o},"6d1d":function(e,n,t){"use strict";Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var o={pages:{"pages/index/index":{navigationBarTitleText:"首页"},"pages/news/news":{navigationBarTitleText:"新闻页"},"pages/test/test":{navigationBarTitleText:"测试页"}},globalStyle:{navigationBarTextStyle:"black",navigationBarTitleText:"uni-app",navigationBarBackgroundColor:"#F8F8F8",backgroundColor:"#F8F8F8"}};n.default=o},"7b19":function(e,n,t){"use strict";var o=function(){var e=this,n=e.$createElement,t=e._self._c||n;return t("App",{attrs:{keepAliveInclude:e.keepAliveInclude}})},a=[];t.d(n,"a",function(){return o}),t.d(n,"b",function(){return a})},a8f1:function(e,n,t){"use strict";t.r(n);var o=t("7b19"),a=t("e01f");for(var i in a)"default"!==i&&function(e){t.d(n,e,function(){return a[e]})}(i);t("27c4");var r=t("2877"),s=Object(r["a"])(a["default"],o["a"],o["b"],!1,null,null,null);n["default"]=s.exports},c055:function(e,n,t){n=e.exports=t("2350")(!1),n.push([e.i,"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n/*每个页面公共css */",""])},c0b5:function(e,n,t){var o=t("c055");"string"===typeof o&&(o=[[e.i,o,""]]),o.locals&&(e.exports=o.locals);var a=t("4f06").default;a("d854aaae",o,!0,{sourceMap:!1,shadowMode:!1})},c5d7:function(e,n,t){"use strict";var o=t("288e"),a=o(t("cebc"));t("cadf"),t("551c"),t("097d"),t("2452"),t("1c31"),t("921b");var i=o(t("e143")),r=o(t("a8f1"));i.default.config.productionTip=!1,r.default.mpType="app";var s=new i.default((0,a.default)({},r.default));s.$mount()},e01f:function(e,n,t){"use strict";t.r(n);var o=t("19b1"),a=t.n(o);for(var i in o)"default"!==i&&function(e){t.d(n,e,function(){return o[e]})}(i);n["default"]=a.a}});