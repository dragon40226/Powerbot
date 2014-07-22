import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.powerbot.script.PollingScript;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Widget;
import org.powerbot.script.rt4.Widgets;

public class GrandExchange extends PollingScript<ClientContext>{
	public final Widget geWidget = ctx.widgets.widget(105); //How to make this static?

	public enum Slot {
		SLOT_1(geWidget.component(28),geWidget.component(170),geWidget.component(174)),
		SLOT_2(geWidget.component(30),geWidget.component(178),geWidget.component(184)),
		SLOT_3(geWidget.component(33),geWidget.component(170),geWidget.component(175)),
		SLOT_4(geWidget.component(35),geWidget.component(170),geWidget.component(175)),
		SLOT_5(geWidget.component(38),geWidget.component(170),geWidget.component(175)),
		SLOT_6(geWidget.component(39),geWidget.component(170),geWidget.component(175));
		//(MAINSLOTCOMPONENT,BUYBUTTONCOMPONENT,SELLBUTTONCOMPONENT)
		private Component slot;
		private Component buyButt;
		private Component sellButt;

		private Slot(Component slot,Component buyButt,Component sellButt){
			this.slot = slot;
			this.buyButt = buyButt;
			this.sellButt = sellButt;
		}

		public Component getSlot() {
			return slot;
		}

		public Component getBuyButt() {
			return buyButt;
		}

		public Component getSellButt() {
			return sellButt;
		}
		public String getCustomizedPrice(){ // gets price you are buying or selling for at specified ge slot
			return getSlot().component(10).text();//returns string .text()
		}

		public String getName(){ //gets name of item at specified ge slot
			return getSlot().component(9).text();
		}

		public double getPercentSold(){ // gets the current width of the bar on the main gewidget and divides it by total width
			int width = getSlot().component(4).width();
			int percentSold = (width/133)*100;
			return customFormat(percentSold); //format is 3 digits with 2 decimal places. returns integer
			
		}
	}
	private Slot slot;
	//TODO IN THE GUI HAVE IT SET TO A SLOT,
	public static double customFormat(double value ) {
	      DecimalFormat myFormatter = new DecimalFormat("###.##");
	      String output = myFormatter.format(value);
		return Double.parseDouble(output);
	   }
	
	public void buyOffer(){//Buy item with specified id at specified slot
		Component currentSlot = slot.getSlot();
		if(currentSlot != null){
			slot.buyButt.interact("");//get actionText of buying
			//type into box item
			
		}
	}

	@Override
	public void poll() {
		// TODO Auto-generated method stub

	}

}
