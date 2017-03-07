/*
 * 	Additional function for calendar.html
 *	Written by ThemePixels	
 *	http://themepixels.com/
 *	
 *	Built for Amanda Premium Responsive Admin Template
 *  http://themeforest.net/category/site-templates/admin-templates
 */


jQuery(document).ready(function() {
		/* initialize the external events */
		jQuery('#external-events div.external-event').each(function() {
		
			// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
			// it doesn't need to have a start or end
			var eventObject = {
				title: jQuery.trim(jQuery(this).text()) // use the element's text as the event title
			};
			
			// store the Event Object in the DOM element so we can get to it later
			jQuery(this).data('eventObject', eventObject);
			
			// make the event draggable using jQuery UI
			jQuery(this).draggable({
				zIndex: 999,
				revert: true,      // will cause the event to go back to its
				revertDuration: 0  //  original position after the drag
			});
			
		});
	
	
		/* initialize the calendar */
		jQuery('#calendar').fullCalendar({
			header: {
				left: 'month,agendaWeek,agendaDay',
				center: 'title',
				right: 'today, prev, next'
			},
            monthNames: ["一月", "二月", "三月", "四月", 　//设置月份名称，中英文均可
                "五月", "六月", "七月", "八月", "九月",
                "十月", "十一月", "十二月"
            ],
            monthNamesShort: ["一月", "二月", "三月", 　　//设置月份的简称
                "四月", "五月", "六月", "七月", "八月",
                "九月", "十月", "十一月", "十二月"
            ],
            dayNames: ["周日", "周一", "周二", "周三", 　　//设置星期名称
                "周四", "周五", "周六"
            ],
            dayNamesShort: ["周日", "周一", "周二", 　　　　//设置星期简称
                "周三", "周四", "周五", "周六"
            ],
            allDaySlot:true,
            axisFormat: 'H(:mm)tt',
            defaultView:"month",
			buttonText: {
				prev: '&laquo;',
				next: '&raquo;',
				prevYear: '&nbsp;&lt;&lt;&nbsp;',
				nextYear: '&nbsp;&gt;&gt;&nbsp;',
				today: '今天',
				month: '月',
				week: '星期',
				day: '天'
			},
			events:[{
				title:"hello world",
				start: '2017-02-22 09:00',
                end: '2017-02-22 18:00',
			}],
			editable: false,
			droppable: true, // this allows things to be dropped onto the calendar !!!
			drop: function(date, allDay) { // this function is called when something is dropped
			
				// retrieve the dropped element's stored Event Object
				var originalEventObject = jQuery(this).data('eventObject');
				
				// we need to copy it, so that multiple events don't have a reference to the same object
				var copiedEventObject = jQuery.extend({}, originalEventObject);
				
				// assign it the date that was reported
				copiedEventObject.start = date;
				copiedEventObject.allDay = allDay;
				
				// render the event on the calendar
				// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
				jQuery('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
				
				// is the "remove after drop" checkbox checked?
				
				jQuery(this).remove();
				
			}
		});
		var events = [];
		jQuery.ajax({
			url:'/dmooc-lich/teacher/getSchedule',
			type:'GET',
			data: null,
			success:function(result){
				for(var i=0;i<result.length;i++){
					console.log(result[i]);
					var appointment = result[i];
					var eurl = appointment.url;
					var etitle = appointment.title;
//					var estart = appointment.startTime;
//					var eend = appointment.endTime;
					var estart = new Date(2017,1,22,22,19,35); 
					var eend = new Date(2017,1,22,23,19,35); 
					var ecolor = "green";
					events.push({
						url:eurl,
						title:etitle,
						start:estart,
						end:eend,
						color:ecolor
					});
				}
				jQuery('#calendar').fullCalendar( 'addEventSource', events );
			},
			error:function(result){
				console.log(result);
			}
		});
		
});
