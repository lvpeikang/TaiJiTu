package app.lvpeikang.com.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val taiji=TaiJiView(this)
        setContentView(taiji)
        val handler:Handler=object :Handler(){
            var degrees=0.0f;
            override fun handleMessage(msg: Message?) {
                super.handleMessage(msg)
                degrees+=2.0f
                taiji.setRotate(degrees)
                this.sendEmptyMessageDelayed(0,20)
            }
        }
        handler.sendEmptyMessageDelayed(0,20);
        // Example of a call to a native method
//        sample_text.text = stringFromJNI()
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    external fun stringFromJNI(): String
//
//    companion object {
//
//        // Used to load the 'native-lib' library on application startup.
//        init {
//            System.loadLibrary("native-lib")
//        }
//    }
}
