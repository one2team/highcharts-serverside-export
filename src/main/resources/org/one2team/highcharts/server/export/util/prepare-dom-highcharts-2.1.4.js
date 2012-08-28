
(function (){
	dp = Document.prototype;
	var x = dp.createElement;
//	dp.createElement = function(tag) {
//    var e;
//    if (tag.charAt(0) == '<') {
//      var div = x.apply(this, [ 'div' ]);
//      div.innerHTML = tag;
//      e = div.firstChild;
//    } else {
//      e = x.apply(this, [ tag ]);
//    }
//
//    e.getBBox = function() {
//      var w = 10;
//      if (e.tagName == "TEXT" && e.firstChild) {
//        var s = e.firstChild.innerHTML;
//        w = s.length * 5;
//      }
//      
//      return {
//        x : e.offsetLeft,
//        y : e.offsetTop,
//        width : w,
//        height : 16
//      };
//    };
//
//    return e;
//  };

  // jsdom doesn't yet support createElementNS, so just fake it up
  dp.createElementNS = function(ns, tag) {
    return this.createElement(tag);
  };

  dp.createStyleSheet = function() {
    return x.apply(this, [ "stylesheet" ]);
  };
	
	
	dp.namespaces = jQuery.makeArray ();
  dp.namespaces.add = document.namespaces.push;
  dp.namespaces.item = function(i) {
    return document.namespaces[i];
  };
	
	dp.detachEvent = function(){};
	dp.attachEvent = function(event, callback){
			document.readyState = 'complete';
			if (event == 'onreadystatechange')
				callback();
	};
		
})();