package WorkShop;
import java.util.ArrayList;
/**
 *
 * @author s31011
 * @version 9/6/18
 */
public class ToolShop  {
    private ArrayList<GeneralPurpose> generalPurpose;
    private ArrayList<BikeTools> bikeTools;
    private ArrayList<PowerTools> powerTools;
    private ArrayList<Sprays> sprays;
    private ArrayList[] tools = new ArrayList[4];
    
    public ToolShop(){
        generalPurpose = new ArrayList<>();
        bikeTools = new ArrayList<>();
        powerTools = new ArrayList<>();
        sprays = new ArrayList<>();
        tools[0] = generalPurpose;
        tools[1] = bikeTools;
        tools[2] = powerTools;
        tools[3] =  sprays;
    }
    
    public void printInventory(){
        for(ArrayList x: tools){
            for(Object t: x){
                Tool tool = ((Tool)(t));
                System.out.println(tool.getName() + ": " + tool.getQuantity());
            }
            System.out.println();
        }
    }
    
    public void adder(Tool tool){
        int index = legend(tool);
        String toolName = tool.getName();
        int n = tool.getQuantity();
        for(int i = 0; i<tools[index].size(); i++){
            if(((Tool)(tools[index].get(i))).getName().equals(toolName)){
                ((Tool)(tools[index].get(i))).changer(n);
                System.out.println("You have " + ((Tool)(tools[index].get(i))).getQuantity() + " " + tool.getName() + " left.");
                return;
            }
        }
        tools[index].add(tool);
        System.out.println("You have successfully added " + n + " " + toolName + ".");
    }
    
    public void remover(Tool tool, int n){
        int index = legend(tool);
        String toolName = tool.getName();
        //Type cast it
        for(int i = 0; i<tools[index].size(); i++){
            if(((Tool)(tools[index].get(i))).getName().equals(toolName)){
                ((Tool)(tools[index].get(i))).changer(n);
                System.out.println("You have " + ((Tool)(tools[index].get(i))).getQuantity() + " " + tool.getName() + " left.");
                if(((Tool)(tools[index].get(i))).getQuantity() <= 2){
                    System.out.println("You are running out. You should purchase more " + tool.getName());
                }
            }
            break;
        }
    }
    
    public int legend(Tool tool){
        if(tool.getType().equals("General Purpose")){
            return 0;
        }else if(tool.getType().equals("Bike Tools")){
            return 1;
        }else if(tool.getType().equals("Power Tools")){
            return 2;
        }else{
            return 3;
        }
    }
    
    public static void main (String [] m) {
        ToolShop t = new ToolShop();
        
        Tool screwDriver1 = new GeneralPurpose("Flat Screw Driver", 15);
        Tool screwDriver2 = new GeneralPurpose("Philip Screw Driver", 15);
        Tool monkeyWrench = new GeneralPurpose("Moneky Wrench", 5);
        Tool allenWrench = new GeneralPurpose("Allen Wrench", 5);
        Tool torxWrench = new GeneralPurpose("Torx Wrench", 2);
        
        Tool chainTool = new BikeTools("Chain Tool", 1);
        Tool bottomBracketTool = new BikeTools("Bottom Bracket Tool", 1);
        Tool spokeWrench = new BikeTools("Spoke Wrenches", 9);
        Tool tireWrench = new BikeTools("Tire Wrench", 12);
        
        Tool pistolGrip = new PowerTools("Pistol Grip Drill", 1);
        Tool airCompressor = new PowerTools("Air Compressor", 2);
        Tool discSander = new PowerTools("Disc Sander", 1);
        Tool angleGrinder = new PowerTools("Angle Grinder", 1);
        Tool rotarySaw = new PowerTools("Rotary Saw", 3);
        Tool flashlight = new PowerTools("Flashlights", 4);
        
        Tool triFlow = new Sprays("Tri-Flow", 7);
        Tool wd40 = new Sprays("WD-40", 6);
        Tool silicone = new Sprays ("Getinge Silicone", 1);
        Tool airCan = new Sprays("Air Can", 3);
        
        t.adder(screwDriver1);
        t.adder(screwDriver2);
        t.adder(monkeyWrench);
        t.adder(allenWrench);
        t.adder(torxWrench);
        t.adder(chainTool);
        t.adder(bottomBracketTool);
        t.adder(spokeWrench);
        t.adder(tireWrench);
        t.adder(pistolGrip);
        t.adder(airCompressor);
        t.adder(discSander);
        t.adder(angleGrinder);
        t.adder(rotarySaw);
        t.adder(flashlight);
        t.adder(triFlow);
        t.adder(wd40);
        t.adder(silicone);
        t.adder(airCan);
        
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        t.printInventory();
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        
        t.remover(screwDriver1, -1);
        t.adder(new GeneralPurpose("Flat Screw Driver", 1));
        t.adder(new Sprays("Tri-Flow", 1));
        t.remover(tireWrench, 2);
        t.remover(triFlow, 1);
        t.remover(wd40, 1);
        t.remover(allenWrench, 1);
        t.remover(screwDriver2, 1);
        
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        t.printInventory();
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }
}
