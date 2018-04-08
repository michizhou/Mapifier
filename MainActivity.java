package bitcamp.sanjitsingh.displaymap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.esri.arcgisruntime.mapping.ArcGISScene;
import com.esri.arcgisruntime.mapping.ArcGISTiledElevationSource;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.Camera;
import com.esri.arcgisruntime.mapping.view.SceneView;

public class MainActivity extends AppCompatActivity {

    private SceneView mSceneView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a scene and add a basemap to it
        ArcGISScene scene = new ArcGISScene();
        scene.setBasemap(Basemap.createImagery());

        //[DocRef: Name=Display Scene-android, Category=Work with 3D, Topic=Display a scene]
        // create SceneView from layout
        mSceneView = (SceneView) findViewById(R.id.sceneView);
        mSceneView.setScene(scene);
        //[DocRef: END]

        //[DocRef: Name=Add elevation to base surface-android, Category=Work with 3D, Topic=Display a scene,
        // RemoveChars=getResources().getString(R.string.elevation_image_service),
        // ReplaceChars=http://elevation3d.arcgis.com/arcgis/rest/services/WorldElevation3D/Terrain3D/ImageServer]
        // create an elevation source, and add this to the base surface of the scene
        ArcGISTiledElevationSource elevationSource = new ArcGISTiledElevationSource(
                getResources().getString(R.string.elevation_image_service));
        scene.getBaseSurface().getElevationSources().add(elevationSource);
        //[DocRef: END]

        // add a camera and initial camera position
        Camera camera = new Camera(28.4, 83.9, 10010.0, 10.0, 80.0, 0.0);
        mSceneView.setViewpointCamera(camera);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // pause SceneView
        mSceneView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // resume SceneView
        mSceneView.resume();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        // dispose SceneView
        mSceneView.dispose();
    }
}