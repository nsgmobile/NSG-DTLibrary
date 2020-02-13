package com.nsg.dtlibrary;

import android.os.Bundle;
import android.os.Environment;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//import com.nsg.nsgdtlibrary.Classes.OldCode.NSGIMainFragment;
import com.nsg.nsgdtlibrary.Classes.util.NSGTiledLayerOnMap;
import com.nsg.nsgdtlibrary.Classes.util.NavigationProperties;

import java.io.File;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created by sailaja.ch NSGI on 27/09/2019
 */
public class NSGApiActivity extends FragmentActivity implements NSGTiledLayerOnMap.FragmentToActivity, View.OnClickListener {
    private int bufferSize=30;
    private String charlsisNumber;
    private  Button Start,Stop;
    private String jobId="1",routeId;


   // private String SourcePosition = "55.0772960 24.9891638";
   // private String DestinationPosition = "55.0819845 24.9945611";
    // 25.26886,55.33279   25.27078,55.3327
   // String routeData="{\"$id\":\"1\",\"Message\":\"Sucess\",\"Status\":\"Success\",\"TotalDistance\":0.00759945944,\"Route\":[{\"$id\":\"2\",\"EdgeNo\":\"795\",\"GeometryText\":\"Take Right at\",\"Geometry\":{\"$id\":\"3\",\"type\":\"LineString\",\"coordinates\":[[55.077337055000044,24.989513851000083],[55.077359766000086,24.989533581000046],[55.077391021000039,24.989560763000043],[55.077444701000047,24.989607446000036],[55.077444701000047,24.989607446000036],[55.077662590000045,24.98979693800004],[55.077878041000076,24.989984395000079],[55.077912018000063,24.990013932000068],[55.077946420000046,24.990043840000055],[55.077946420000046,24.990043840000055],[55.078093126000056,24.99017137800007],[55.078331198000058,24.990378494000083],[55.078331198000058,24.990378494000083],[55.07834979900008,24.990394676000051],[55.078368644000079,24.99041112000009],[55.07859588000008,24.990609405000043],[55.078669280000042,24.990673135000065],[55.078669280000042,24.990673135000065],[55.078793551000047,24.990781024000057],[55.078793551000047,24.990781024000057],[55.078966782000066,24.990931354000054],[55.078966782000066,24.990931354000054],[55.078985203000059,24.990947340000048],[55.079006466000067,24.990965886000083],[55.079056506000086,24.991009530000042],[55.079056506000086,24.991009530000042],[55.079185360000054,24.991121917000044],[55.079382465000037,24.991293025000061],[55.079382465000037,24.991293025000061],[55.079400270000065,24.991308482000079],[55.079423147000057,24.991328383000052],[55.079475077000041,24.991373560000056],[55.079475077000041,24.991373560000056],[55.079557869000041,24.991445584000076],[55.079729863000068,24.991595232000066],[55.079838884000083,24.991690348000077],[55.079880506000052,24.991726661000087],[55.079880506000052,24.991726661000087],[55.079983642000059,24.991816644000039],[55.080127243000049,24.991941915000041],[55.080127243000049,24.991941915000041],[55.080252188000031,24.992050911000035],[55.080252188000031,24.992050911000035],[55.080317214000047,24.992107636000071],[55.080571947000067,24.99232922300007],[55.080828445000066,24.992552495000041],[55.081080734000068,24.992771984000058],[55.081167913000058,24.992848033000087],[55.081343550000042,24.99300095500007]]}},{\"$id\":\"4\",\"EdgeNo\":\"974\",\"GeometryText\":\"Take Right at\",\"Geometry\":{\"$id\":\"5\",\"type\":\"LineString\",\"coordinates\":[[55.081343550000042,24.99300095500007],[55.08135462100006,24.993021451000061],[55.081361895000043,24.993043312000054],[55.081365180000034,24.993065960000081],[55.081364388000054,24.993088793000084],[55.08135954100004,24.993111206000037],[55.081350766000071,24.993132605000085]]}},{\"$id\":\"6\",\"EdgeNo\":\"174\",\"GeometryText\":\"Take Right at\",\"Geometry\":{\"$id\":\"7\",\"type\":\"LineString\",\"coordinates\":[[55.081350766000071,24.993132605000085],[55.080860358000052,24.99360129300004]]}},{\"$id\":\"8\",\"EdgeNo\":\"1644\",\"GeometryText\":\"Take Right at\",\"Geometry\":{\"$id\":\"9\",\"type\":\"LineString\",\"coordinates\":[[55.080860358000052,24.99360129300004],[55.080860760000064,24.993614882000088],[55.080863357000055,24.993628267000076],[55.080868093000049,24.99364115700007],[55.080874864000066,24.993653269000049],[55.080883521000032,24.993664338000087],[55.080893875000072,24.993674122000073],[55.080893875000072,24.993674122000073],[55.081371598000032,24.994080276000091],[55.081371598000032,24.994080276000091],[55.081396983000047,24.99410253700006],[55.081396983000047,24.99410253700006],[55.081938199000035,24.994588758000077]]}}]}";

     private String SourcePosition = "55.067291 24.978782";
     private String DestinationPosition = "55.067205 24.979878";
    // 25.26886,55.33279   25.27078,55.3327
     String routeData="\n" +
            "\n" +
            "{\"$id\":\"1\",\"Message\":\"Sucess\",\"Status\":\"Success\",\"TotalDistance\":0.00884315523,\"Route\":[{\"$id\":\"2\",\"EdgeNo\":\"102\",\"GeometryText\":\"Take Right \n" +
            "at Shell Trading Middle East Private Limited\",\"Geometry\":{\"$id\":\"3\",\"type\":\"LineString\",\"coordinates\":[[55.06727997182,24.9787947412557],\n" +
            "[55.067020892000073,24.978570495000042],[55.066790925000078,24.978370131000077],[55.066620030000081,24.978221328000075],\n" +
            "[55.06650374700007,24.97812037500006],[55.066452143000049,24.978075252000053],[55.066388841000048,24.978020054000069],\n" +
            "[55.066216137000083,24.977870199000051],[55.06598632500004,24.97767018400009],[55.065755946000081,24.977470103000087],\n" +
            "[55.065526233000071,24.977270178000083],[55.065312867000046,24.977084458000036]]}},{\"$id\":\"4\",\"EdgeNo\":\"1334\",\"GeometryText\":\"Take Right \n" +
            "at\",\"Geometry\":{\"$id\":\"5\",\"type\":\"LineString\",\"coordinates\":[[55.065312867000046,24.977084458000036],[55.065287629000068,24.977076221000061],\n" +
            "[55.065261227000065,24.97707199000007],[55.065234420000081,24.97707188600009],[55.065207979000036,24.977075912000089],\n" +
            "[55.065182665000066,24.97708395300009],[55.065159206000033,24.977095778000091],[55.065138276000084,24.977111045000072],\n" +
            "[55.065138276000084,24.977111045000072],[55.065120166000042,24.977128114000038],[55.064756250000073,24.977475793000053],\n" +
            "[55.064379641000073,24.977835331000051],[55.064249201000052,24.977960644000063],[55.064249201000052,24.977960644000063],\n" +
            "[55.064238539000087,24.977972603000069],[55.064230288000033,24.977986052000062],[55.064224693000085,24.978000592000058],\n" +
            "[55.064221918000044,24.978015793000054],[55.064222048000033,24.978031201000078],[55.064222048000033,24.978031201000078],\n" +
            "[55.064387059000069,24.978174369000044],[55.064439134000054,24.978219639000088],[55.064439134000054,24.978219639000088],\n" +
            "[55.064525820000085,24.978294996000045],[55.064525820000085,24.978294996000045],[55.064649532000033,24.978402540000047],\n" +
            "[55.06498055600008,24.978690915000072],[55.06498055600008,24.978690915000072],[55.065164137000068,24.978850842000043],\n" +
            "[55.065338824000037,24.979002188000038],[55.065338824000037,24.979002188000038],[55.065422408000074,24.979074604000061],\n" +
            "[55.065573362000066,24.979205705000084],[55.065573362000066,24.979205705000084],[55.065666012000065,24.979286171000069],\n" +
            "[55.065666012000065,24.979286171000069],[55.065681098000084,24.979299272000048],[55.065938324000058,24.979522600000053],\n" +
            "[55.066002768000033,24.979578645000061],[55.066002768000033,24.979578645000061],[55.066081442000041,24.979647065000051],\n" +
            "[55.066081442000041,24.979647065000051],[55.066110416000072,24.979672262000065],[55.066245676000051,24.979789959000072],\n" +
            "[55.066245676000051,24.979789959000072],[55.06634370900008,24.979875263000054],[55.06634370900008,24.979875263000054],\n" +
            "[55.066752725000072,24.980231166000067],[55.066752725000072,24.980231166000067],[55.066772902000082,24.980240215000038],\n" +
            "[55.066794299000037,24.98024651500009],[55.066816470000049,24.980249936000064],[55.066838951000079,24.980250405000049],\n" +
            "[55.066861270000061,24.980247913000085]]}},{\"$id\":\"6\",\"EdgeNo\":\"443\",\"GeometryText\":\"-\",\"Geometry\":\n" +
            "{\"$id\":\"7\",\"type\":\"LineString\",\"coordinates\":[[55.066861270000061,24.980247913000085],[55.0672260238388,24.9799000715094]]}}]}";

   //  private String SourcePosition = "55.33279 25.26886";
   //  private String DestinationPosition = "55.3327 25.27078";
   // 25.26886,55.33279   25.27078,55.3327
   //String routeData="{\"$id\": \"1\",\"Message\": \"Sucess\",\"Status\": \"Success\",\"TotalDistance\": 0.04324998409,\"Route\": [{\"$id\": \"114\",\"EdgeNo\": \"1817\",\"GeometryText\": \"-\",\"Geometry\": {\n"+
   //       "\"$id\": \"115\",\"type\": \"LineString\",\"coordinates\": [[55.33279,25.26886],[55.33314,25.26797],[55.33249,25.26771 ],[55.33196,25.26755],[55.33147,25.26733 ],[55.33089,25.26717],[55.33063,25.2672],[55.33064,25.26776],[55.33072,25.26849],[55.33071,25.26907],[55.33064,25.26961],[55.33066,25.27013 ],[55.33098,25.2704],[55.33156,25.27057],[55.33225,25.27069],[55.3327,25.27078]]}}]}";


   // private String  routeData="{\"$id\":\"1\",\"Message\":\"Sucess\",\"Status\":\"Success\",\"TotalDistance\":0.00884315523,\"Route\":[{\"$id\":\"2\",\"EdgeNo\":\"102\",\"GeometryText\":\"-\",\"Geometry\":{\"$id\":\"3\",\"type\":\"LineString\",\"coordinates\":[[78.571275,17.473804],[78.571132,17.473587],[78.570936,17.473375],[78.570724,17.473250],[78.570370,17.473004],[78.569989,17.472763],[78.569373,17.472311],[78.568690,17.471816],[78.568026,17.471415],[78.566716,17.470434],[78.565718,17.469347],[78.564651,17.468051]]}}]}";
  //  String SourcePosition="78.571275 17.473804";
   // String DestinationPosition="78.564651 17.468051";
    private TextView tv;
    private String routeDeviatedDT_URL="http://202.53.11.74/dtnavigation/api/routing/routenavigate";
    String BASE_MAP_URL_FORMAT = Environment.getExternalStorageDirectory() + File.separator + "MBTILES" + File.separator + "DubaiBasemap"+".mbtiles";
    private String AuthorisationKey="b3TIz98wORn6daqmthiEu48TAW1ZEQjPuRLapxJPV6HJQiJtO9LsOErPexmDhbZtD76U2AbJ+jXarYr3gAqkkddT7FGFXYcczWMZiFyXvww2A1T1OocgvsaMYzr6Opq72aJoX8xlKYd+JD9dy0x31w==";
    String CSVFile_Path= Environment.getExternalStorageDirectory() + File.separator + "MBTILES" + File.separator + "RouteSample"+".txt";
  //  com.nsg.dtlibrary.NavigationProperties properties=new com.nsg.dtlibrary.NavigationProperties();

    NSGTiledLayerOnMap test = new NSGTiledLayerOnMap(BASE_MAP_URL_FORMAT,SourcePosition,DestinationPosition,routeData,routeDeviatedDT_URL,AuthorisationKey);
  // NSGTiledLayerOnMap test = new NSGTiledLayerOnMap(BASE_MAP_URL_FORMAT);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_map);
        Start =(Button)findViewById(R.id.start);
        Start.setOnClickListener(this);
        Stop=(Button)findViewById(R.id.stop);
        Stop.setOnClickListener(this);


        Bundle NSGIBundle = getIntent().getExtras();
        charlsisNumber = NSGIBundle.getString("charlsisNumber");

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
         if(charlsisNumber.equals("RD1")) {
              fragmentTransaction.add(R.id.map_container, test);
         }else if(charlsisNumber.equals("RD2")) {

        }
        fragmentTransaction.commit();

    }

    @Override
    public String communicate(String comm) {
        return null;
    }

    @Override
    public String communicate(String comm, int alertType) {
        Log.d("received", " Recieved From ETA Listener---"+ comm + "alert type "+ alertType);
        if(alertType==MapEvents.ALERTTYPE_6){
            // if alert recieved you can start navigation here
           // test.startNavigation();
           // Log.e("Started","Started "+test.startNavigation());
        }else if(alertType==MapEvents.ALERTTYPE_1){

        }else if(alertType==MapEvents.ALERTTYPE_2){

        }else if(alertType==MapEvents.ALERTTYPE_3){

        }else if(alertType==MapEvents.ALERTTYPE_4){

        }else if(alertType==MapEvents.ALERTTYPE_5){

        }
        return comm;
    }
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {
       if(v==Start){
           test.startNavigation();
          // Log.e("Started","Started "+test.startNavigation());
       }else if(v==Stop){
           test.stopNavigation();
          // Log.e("Stopped","Stopped "+test.stopNavigation());
       }
    }
}