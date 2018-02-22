Object.size = function (obj) {
    var size = 0,
        key;
    for (key in obj) {
        if (obj.hasOwnProperty(key)) {
            size++;
        }
    }
    return size;
};

function IsNumeric(val) {
    if (isNaN(parseFloat(val))) {
        return false;
    }
    return true;
}

var AfdWidget = Backbone.Model.extend({
    allowed: ['hash', 'provider', 'template', 'theme', 'target'],
    allowedTargets: ['_blank', '_top', '_parent', 'window.content'],
    defaults: {
        "provider": "conduit",
        "template": 200,
        "theme": 0,
        "domain": "d.foxadd.com",
        "trackingDomain" : 'counter-817696455.us-east-1.elb.amazonaws.com',
        "adDelay": 20000,
        "colors": [["#000000", "#ffffff"],["#000000", "#ffffff"]],
        "env": "production",
        "target": "_blank",
        "cookieExp": 0.25
    },
    getToolbarId: function () {
        type = this.get("provider");
       
        switch (type) {
        case 'conduit':
            try {
                if ((typeof BcApiObj === 'object') && ((typeof BcApiObj.GetToolbarId) === 'function')) {
                	if(BcApiObj.GetToolbarId() !== undefined){
                		this.set('tid',BcApiObj.GetToolbarId());
                	}else{
                	    setTimeout('try { afdWidget.getToolbarId();} catch (e){}', 1000);
                	    this.set('tid', type + '_null');
                	}
                }else{
                    setTimeout('try { afdWidget.getToolbarId();} catch (e){}', 1000);
                    this.set('tid', type + '_null');
                }
               
            } catch (e) {
                this.set('tid', type + '_null');
                this.d(e);
            }
            break;
        case 'montiera':
            try {
                this.set('tid', escrt.getNamedProp("tlbrid"));
            } catch (e2) {
           		setTimeout('try { afdWidget.getToolbarId();} catch (e){}', 1000);
                this.set('tid', type + '_null');
                this.d(e2);
            }
            break;
        case 'sweetim':
            this.set('tid', type + '_null');
            break;
        }
    },
    initUrlParams: function () {
        q = window.location.search.substring(1);
        var params = {}, queries, temp, i, l;
        queries = q.split("&");
        for (i = 0, l = queries.length; i < l; i++) {
            temp = queries[i].split('=');
            if (_.include(this.allowed, temp[0])) {
                if (temp[0] === 'target') {
                    if (_.include(this.allowedTargets, temp[1])) {
                        this.set(temp[0], temp[1]);
                    }
                } else {
                    this.set(temp[0], temp[1]);
                }
            }
        }
        this.url = function () {
            return '//' + this.get("domain") + '/rpc.php?hash=' + this.get("hash");
        };
    },
    initialize: function () {
        this.initUrlParams();
        this.getToolbarId();
		//this.set("target","dsdsfdsf");
        if (this.get('provider') === 'sweetim') {
            // if browser is chrome set target to _blank and don't add #mainwindow to url
            if($.browser.chrome){
				this.set("target","_blank");
            }
        }
		
        //TODO: add random to t
        this.set('pixelUrl', '//' + this.get("trackingDomain") + '/blank.gif' + '?t=' + (new Date().getTime()));
        this.fetch();
    },
    decodeJSON: function (src) {
        if (typeof (jQuery.JSON) === 'object' && jQuery.JSON.parse) {
            return jQuery.JSON.parse(src);
        }
        return eval("(" + src + ")");
    },
    encodeJSON: function (o) {
        if (typeof (jQuery.JSON) === 'object' && jQuery.JSON.stringify) {
            return jQuery.JSON.stringify(o);
        }
        var type = typeof (o);
        if (o === null) {
            return "null";
        }
        if (type === "undefined") {
            return undefined;
        }
        if (type === "number" || type === "boolean") {
            return o + '';
        }
        if (type === "string") {
            return this.quoteStringJSON(o);
        }
        if (type === 'object') {
            if (typeof o.toJSON === "function") {
                return this.encodeJSON(o.toJSON());
            }
            if (o.constructor === Date) {
                var month = o.getUTCMonth() + 1;
                if (month < 10) {
                    month = '0' + month;
                }
                var day = o.getUTCDate();
                if (day < 10) {
                    day = '0' + day;
                }
                var year = o.getUTCFullYear();
                var hours = o.getUTCHours();
                if (hours < 10) {
                    hours = '0' + hours;
                }
                var minutes = o.getUTCMinutes();
                if (minutes < 10) {
                    minutes = '0' + minutes;
                }
                var seconds = o.getUTCSeconds();
                if (seconds < 10) {
                    seconds = '0' + seconds;
                }
                var milli = o.getUTCMilliseconds();
                if (milli < 100) {
                    milli = '0' + milli;
                }
                if (milli < 10) {
                    milli = '0' + milli;
                }
                return '"' + year + '-' + month + '-' + day + 'T' + hours + ':' + minutes + ':' + seconds + '.' + milli + 'Z"';
            }

            if (o.constructor === Array) {
                var ret = [];
                var i;
                for (i = 0; i < o.length; i++) {
                    ret.push(this.encodeJSON(o[i]) || "null");
                }

                return "[" + ret.join(",") + "]";
            }

            var pairs = [];
            for (var k in o) {
                var name;
                var type = typeof k;

                if (type == "number") name = '"' + k + '"';
                else if (type == "string") name = this.quoteStringJSON(k);
                else continue; // skip non-string or number keys

                if (typeof o[k] == "function") continue; // skip pairs where the value is a function.

                var val = this.encodeJSON(o[k]);

                pairs.push(name + ":" + val);
            }

            return "{" + pairs.join(", ") + "}";
        }
    },
    quoteStringJSON: function (string) {
        if (string.match(this._escapeable)) {
            return '"' + string.replace(this._escapeable, function (a) {
                var c = this._meta[a];
                if (typeof c === 'string') return c;
                c = a.charCodeAt();
                return '\\u00' + Math.floor(c / 16).toString(16) + (c % 16).toString(16);
            }) + '"';
        }
        return '"' + string + '"';
    },
    _escapeable: /["\\\x00-\x1f\x7f-\x9f]/g,
    _meta: {
        '\b': '\\b',
        '\t': '\\t',
        '\n': '\\n',
        '\f': '\\f',
        '\r': '\\r',
        '"': '\\"',
        '\\': '\\\\'
    },
    cookie: function (name, value, options) {
        if (typeof value != 'undefined') { // name and value given, set cookie
            options = options || {};
            if (value === null) {
                value = '';
                options.expires = -1;
            }
            var expires = '';
            if (options.expires && (typeof options.expires == 'number' || options.expires.toUTCString)) {
                var date;
                if (typeof options.expires == 'number') {
                    date = new Date();
                    date.setTime(date.getTime() + (options.expires * 24 * 60 * 60 * 1000));
                } else {
                    date = options.expires;
                }
                expires = '; expires=' + date.toUTCString();
            }
            var path = options.path ? '; path=' + (options.path) : '';
            var domain = options.domain ? '; domain=' + (options.domain) : '';
            var secure = options.secure ? '; secure' : '';
            this.setCookie( [name, '=', encodeURIComponent(value), expires, path, domain, secure] );
        } else {
            var cookieValue = null;
            var dCookie = this.getCookie( name );
            if (dCookie && dCookie != '') {
                var cookies = dCookie.split(';');
                for (var i = 0; i < cookies.length; i++) {
                    var cookie = jQuery.trim(cookies[i]);
                    if (cookie.substring(0, name.length + 1) == (name + '=')) {
                        cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                        break;
                    }
                }
            }
            return cookieValue;
        }
    },
    getCookie: function ( name ) {
        if ( this.get("provider") == 'montiera' ) {
        	try {
	        	var cookieData = escrt.getNamedProp('afd-'+name);
	        	if ( typeof cookieData == "string" && cookieData.length > 0 ) {
	        		data = cookieData.split(';');
	        		for ( var index in data ) {
	        			var value = data[index].split('=');
	        			if ( value[0] == ' expires' ) {
	        				var exptime = new Date( Date.parse( value[1] ) );
	        				exptime = parseInt( exptime.getTime() );
	        				var curtime = new Date()
	        				curtime = parseInt( curtime.getTime() );
	        				
	        				if ( exptime >= curtime ) {
	        					return name+'='+data[0];
	        				} else {
	        					try {
	        						escrt.setNamedProp( 'afd-'+name,'' );
	        					} catch (e) {}
	        					return '';
	        				}
	        			}
	        		}
	        	} 
        	} catch (e) {
        		this.d('Error montiera storage getting data.'+e);
        	}
        }
       	return document.cookie;
    },
    setCookie: function ( cookieItem ) {
    	var cookieData = cookieItem.join('');
        if ( this.get("provider") == 'montiera' ) {
        	date = new Date();
        	if (cookieItem[3] !== '') { 
	        	try {
	        		escrt.setNamedProp( 'afd-'+cookieItem[0], cookieItem[2]+cookieItem[3] );
	        	} catch (e) {
	        		this.d('Error montiera storage inserting.');
	        	}
        	}
        }
       	document.cookie = cookieData;
    },
    d: function (o) {
        if (this.get("env") == 'dev') {
        	try{
	            if(typeof console === 'object' && typeof console.log === 'function'){
	            	console.log(o);
	            }
	            else
	            	alert(this.encodeJSON(o));
	            		
        	}catch(e){
        		alert(o);
        	}
        	//alert(this.encodeJSON(o));
        }
    },
    trackView: function (empty, cids) {
    	if (this.isMSIE) {
    		// code for IE browser. Using document create element
    		var img = document.createElement('img');
    	} else {
    		var img = new Image(1, 1);
    	}
    	img.src = this.get("pixelUrl") + '&h=' + this.get("hash") + '&tid=' + this.get("tid") + ( (empty) ? '&emp=1' : ('&cids=' + cids) );
   		if (this.isMSIE) {
    		document.body.appendChild(img);
    	}    	
    },
    isMSIE: function(){
    	// MS IE Detection Recommended from Microsoft: http://msdn.microsoft.com/en-us/library/ms537509(v=vs.85).aspx
    	return (navigator.appName == 'Microsoft Internet Explorer');
    },
    fetch: function () {
        var now = new Date();
        hours = now.getHours();
        now.setHours(hours + 3);
        var expiresDateO = now;
        var addons = null;
        var hash = this.get("hash");
        var t = this;
        var cookieExp = this.get("cookieExp");

        if (hash && hash != '') {
            if (this.decodeJSON(this.cookie(hash)) && this.decodeJSON(this.cookie(hash + '_wid')) && this.decodeJSON(this.cookie(hash + '_wid'))) {
                addons = this.decodeJSON(this.cookie(hash));
                this.set("items", addons.items);
                this.set("wid", this.cookie(hash + '_wid'));
            } else {
                if (!this.cookie(hash + '_wid_to')) {
                    $.ajax({
                        async: false,
                        url: this.url(),
                        success: function (data) {
                            if (data) {
                                cids = data.cids;
                                delete data.cids;
                                cids = cids.join(',');
                                t.cookie(hash + '_wid', data.wid, {
                                    expires: cookieExp
                                });
                                t.cookie(hash, t.encodeJSON(data), {
                                    expires: cookieExp
                                });
                                t.set("items", data.items);
                                t.set("wid", t.cookie(hash + '_wid'));
                                t.trackView(false, cids);

                            } else {
                                t.trackView(true);
                                t.cookie(hash + '_wid_to', 1, {
                                    expires: expiresDateO
                                });
                            }
                        }
                    });
                }
            }
        }

    }
});

var WidgetViewBase = Backbone.View.extend({
    el: $("#wrapper"),
    adoptions: ['monteraApiAdaption', 'sweetimApiAdoption'],
    getInternetExplorerVersion: function ()
    {
        var rv = -1; 
        if (navigator.appName == 'Microsoft Internet Explorer') {
            var ua = navigator.userAgent;
            var re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
            if (re.exec(ua) != null) rv = parseFloat(RegExp.$1);
        }
        return rv;
    },
    supportsAnimatedGif: function () {
        var ver = this.getInternetExplorerVersion();

        if (ver > -1) {
            if (ver >= 9.0) return true;
            else return false;
        } else {
            return true;
        }
    },
    runAdoptions: function (link) {
        var t = this;
        _.each(this.adoptions, function (v, k) {
            t[v](link);
        });
    },
    loadCssFile: function (path) {
    	var fi = path.lastIndexOf("/") + 1;
    	var filename = path.substr(fi);
    	path = path.substr(0,fi);
    	var splited = filename.split('.');
    	splited.splice(splited.length-1,0,"min");
    	filename = splited.join('.');
    	path = path + filename;
    	path = '//'+this.getCdnDomain()+path;
        var fileref = document.createElement("link");
        fileref.setAttribute("rel", "stylesheet");
        fileref.setAttribute("type", "text/css");
        fileref.setAttribute("href", path);
        if (typeof fileref != "undefined") {
            document.getElementsByTagName("head")[0].appendChild(fileref);
        }
    },
    initialize: function () {
        _.bindAll(this, 'render'); // fixes loss of context for 'this' within
    },
    sweetimApiAdoption: function (link) {
        if (this.model.get('provider') === 'sweetim') {
            url = link.attr('href');
            // if browser is chrome set target to _blank and don't add #mainwindow to url
            if($.browser.chrome){
                $(link).attr('target', '_blank');
            }
            else{
                if(url.indexOf('#mainwindow') == -1){
                	url = url + '#mainwindow';
                }
                $(link).attr('target', this.model.get("target"));
            }
            $(link).attr('href', url);
        }
        
        
		if(this.model.get('theme') == '3')
			this.imbgSetImgAndColor();
		
		
    },
    monteraApiAdaption: function (link) {
    	var t = this;
        if (this.model.get("provider") === 'montiera') {
            link.click(function (e) {
                e.preventDefault();
                var hrefVal;
                if (e.currentTarget.attributes.getNamedItem('href') !== null) {
                    hrefVal = e.currentTarget.attributes.getNamedItem('href').nodeValue;
                    // hrefVal = hrefVal.substring(1);
                }
                if (hrefVal) {
                    if (hrefVal.substr(0, 5) == 'http:') {
                        var url = hrefVal;
                    } else {
                        var url = '//' + t.model.get("domain") + hrefVal;
                    }
                    escrt.nvgtMain(url);
                }

            });
        }
    },
    incBarGameSlideShow: function (addon) {
    	var t = this;
    	$("#lnk").slideUp(500, function () {
			t.imbgSetImgAndColor();
            $(t.el).children("#lnk").attr('href', t.prepareClickUrl(addon));
            $(t.el).children("#lnk").attr('target', t.model.get('target'));
			$(t.el).children("#lnk").children("#text").text(addon.title);
            $("#lnk").slideDown(500);
          });
		  
    },
	imbgSetImgAndColor:function(linkObj){

		var linkObj = $("#lnk");
		var imgsArr = this.model.get("incImgArray")
		var ind = Math.floor(Math.random()*imgsArr.length)
		linkObj.css("color",imgsArr[ind][1])
		linkObj.children("img").attr('src', "http://cdn.foxadd.com/images/widget/toolbar/similar/"+imgsArr[ind][0]);
	
	},
    slideshow1: function (addon) {
        var t = this;
        $("#bubble").fadeOut(1000, function () {
            var txt = $(t.el).children("#main").children("#lnk").children("#bubble").children("#text-wrapper");
            txt.children("#text").text(addon.title);
            $(t.el).children("#main").children("#lnk").attr('href', t.prepareClickUrl(addon));
            $(t.el).children("#main").children("#lnk").attr('target', t.model.get('target'));
            $("#bubble").fadeIn(1000,function(){
            	t.runAdoptions($("#lnk"));
            });
            
        });
    },
    slideshow: function (addon) {
        var colors = this.model.get("colors");
       

        var effects = [
            [
                [1000, {
                    opacity: 0
                }],
                [1000, {
                    opacity: 1
                }]
            ],
            [
                [1000, {
                    opacity: 1,
                    marginLeft: '+=' + $(this.el).outerWidth()
                }],
                [1000, {
                    opacity: 1,
                    marginLeft: '-=' + $(this.el).outerWidth()
                }]
            ],
            [
                [1000, {
                    opacity: 1,
                    width: 0
                }],
                [1000, {
                    opacity: 1,
                    width: "100%"
                }]
            ],
            [
                [1000, {
                    opacity: 0,
                    height: 0
                }],
                [1000, {
                    opacity: 1,
                    height: "25px"
                }]
            ],
            [
                [1000, {
                    opacity: 0,
                    marginLeft: '+=' + ($(this.el).outerWidth() / 2),
                    marginTop: '+=' + ($(this.el).outerHeight() / 2),
                    height: 0,
                    width: 0,
                    duration: 500
                }],
                [1000, {
                    opacity: 1,
                    marginLeft: '-=' + ($(this.el).outerWidth() / 2),
                    marginTop: '-=' + ($(this.el).outerHeight() / 2),
                    width: "100%",
                    height: "25px"
                }]
            ]
        ];

        var trig = Math.floor(Math.random() * effects.length);
        var trig2 = Math.round(Math.random());
        var blinkLen = 200;
        var link = $(this.el).children('a');
        var t = this;
        $(this.el).animate(
        effects[trig][0][1],
        effects[trig][0][0],
        function () {
        	var rndColorIndex = (Math.floor(Math.random() * colors.length));
            link.attr('href',t.prepareClickUrl(addon)).find('em').html(addon['title']);
            $(t.el).children('a').css('background-color', colors[rndColorIndex][0]);
            $(t.el).children('a').css('color', colors[rndColorIndex][1]);
            $(t.el).children('a').css('border-color', colors[rndColorIndex][1]);
            $(t.el).children('a').children('span').css('color', colors[rndColorIndex][1]);
            $(t.el).children('a').children('span').css('background-color', colors[rndColorIndex][0]);
            if (trig2) {
                $(t.el).children('a').css('background-color', colors[rndColorIndex][0]);
                $(t.el).children('a').fadeOut(blinkLen).fadeIn(blinkLen).fadeOut(blinkLen).fadeIn(blinkLen).fadeOut(blinkLen).fadeIn(blinkLen).fadeOut(blinkLen).fadeIn(blinkLen);
                $(t.el).children('a').css('cursor', 'hand');
            }
            $(t.el).children('a').mouseover(function () {
                $(this).children('span').css('color', colors[rndColorIndex][0]);
                $(this).children('span').css('background-color', colors[rndColorIndex][1]);
                $(this).css('color', colors[rndColorIndex][0]);
                $(this).css('background-color', colors[rndColorIndex][1]);
            }).mouseout(function () {
                $(this).children('span').css('color', colors[rndColorIndex][1]);
                $(this).children('span').css('background-color', colors[rndColorIndex][0]);
                $(this).css('color', colors[rndColorIndex][1]);
                $(this).css('background-color', colors[rndColorIndex][0]);
            });
            $(t.el).animate(effects[trig][1][1], effects[trig][1][0], function () {
                // Animation complete.
                // TODO: count addon impression
                t.runAdoptions(link);
            });
        });
    },
    animate: function (addons) {
        var i = 0;
        var t = this;
        var addon;
        var theme = '' + t.model.get("theme");
        var delay = t.model.get("adDelay") ? t.model.get("adDelay") : 20000;
        var timer = window.setInterval(function () {
            i = (i == Object.size(addons) - 1) ? 0 : i + 1;
            addon = addons[i];
            switch (theme) {
            case '1':
                t.slideshow1(addon);
                break;
            case '2':
                t.slideshow1(addon);
                break;
            case '3':
                t.incBarGameSlideShow(addon);
                break;
            default:
                t.slideshow(addon);
            }

        }, delay);
    },
    initView: function (addon) {
        this.model.set('baseClickUrl', '/widget/download/id/');
        var theme = '' + this.model.get("theme");
        switch (theme) {
        case '1':
            this.yojikInitView(addon); //widget-fd-s-4.html
            break;
        case '2':
            this.yojikInitView(addon); //widget-fd-s-5.html
            break;
        case '3':
            this.incBarGameInitView(addon); //incredimail tool bar
            break;
        default:
            this.classicInitView(addon);
        }
    },
    prepareClickUrl : function(addon){
    	var baseClickUrl = this.model.get('baseClickUrl');
    	var url = baseClickUrl + addon.id + '?tid='+this.model.get('tid');
    	return url;
    },
    yojikInitView: function (addon) {
    	var t = this;
        var url = this.prepareClickUrl(addon);
        var characterUrl;
        var characters = this.getCharacterIcons();
        switch (this.model.get("theme")) {
        case '1':
            characterUrl = 'http://' + this.getCdnDomain() + '/images/widget/toolbar/similar/fuzzy22.' + this.model.get('chractersExtension');
            break;
        case '2':
            i = Math.floor(Math.random() * characters.length);
            characterUrl = characters[i];
            break;
        default:
            characterUrl = 'http://' + this.getCdnDomain() + '/images/widget/toolbar/similar/fuzzy22.' + this.model.get('chractersExtension');
            break;
        }
        var tmpl = '<div id="main"><a id="lnk" href="' + url + '" target="' + this.model.get("target") + '"><img id="fuzzy" src="' + characterUrl + '" /><span id="bubble"><span id="text-wrapper"><span id="text">' + addon.title + '</span></span></span></a></div>';
        $(this.el).append(tmpl);
        $("#fuzzy").animate({
            opacity: 0.9,
            top: '-=17'
        }, 1000, 'swing', function () {
            $("#bubble").animate({
                top: '-=25'
            }, 500,function(){
            	t.runAdoptions($("#lnk"));
            });
        });

        this.runAdoptions($("#lnk"));
    },
    incBarGameInitView: function (addon) {
        html = '<a id="lnk" class="afdlnk" href="' + this.prepareClickUrl(addon);
        html += '" target="' + this.model.get("target") + '">';
        html += '<img  src=""/>';
        html += '<em id="text">' + addon.title + '</em>';
        html += '</a>';
        $(this.el).append(html);
        if (this.model.get("template") == 201) {
            // workaround to support 140 width for ie6/7
            $("#wrapper").children(":first-child").width(128);
            $("#wrapper").addClass('toolbar_short');
        }
        this.runAdoptions($("#lnk"));
    },
    classicInitView: function (addon) {
        html = '<a id="lnk" class="afdlnk" href="' + this.prepareClickUrl(addon);
        html += '" target="' + this.model.get("target") + '">';
        html += '<em id="text">' + addon.title + '</em>';
        html += '</a>';
        $(this.el).append(html);
        if (this.model.get("template") == 201) {
            // workaround to support 140 width for ie6/7
            $("#wrapper").children(":first-child").width(128);
            $("#wrapper").addClass('toolbar_short');
        }
        this.runAdoptions($("#lnk"));
    },
    getCdnDomain: function () {
    	if(this.model.get('cdnDomain') !== undefined && this.model.get('cdnDomain') !== ''){
    		return this.model.get('cdnDomain');
    	}
        var domain = this.model.get('domain');
        return 'cdn.' + domain.substring(2);
    },
    getCharacterIcons: function () {
        var domain = this.getCdnDomain();
        //TODO: redundant
        this.model.set('chractersExtension', 'gif');
        this.model.set('characters', ['http://' + domain + '/images/widget/toolbar/similar/fuzzy2.' + this.model.get('chractersExtension'),
                                      'http://' + domain + '/images/widget/toolbar/similar/fuzzy3.' + this.model.get('chractersExtension'),
                                      'http://' + domain + '/images/widget/toolbar/similar/fuzzy.'  + this.model.get('chractersExtension')]);
        return this.model.get('characters');
    },
    d: function (o) {
        if (this.model.attributes.env == 'dev') {
	            if(typeof console === 'object' && typeof console.log === 'function'){
	            	console.log(o);
	            }
        }
    },
    render: function () {
        var addons = this.model.get('items');
        if ((addons != undefined && addons.length !== undefined) && addons.length) {
            if (addons[0] !== undefined) {
                var theme = this.model.get('theme');
                this.initView(addons[0]);
            }
            this.animate(addons);
        }
       
    }
});


(function($) {
    $.rand = function(arg) {
        if ($.isArray(arg)) {
            return arg[$.rand(arg.length)];
        } else if (typeof arg === "number") {
            return Math.floor(Math.random() * arg);
        } else {
            return 4;  // chosen by fair dice roll
        }
    };
})(jQuery);