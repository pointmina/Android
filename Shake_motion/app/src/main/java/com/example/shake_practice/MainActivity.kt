package com.example.shake_practice

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.shake_practice.R.drawable.slightly_smiling_face
import com.example.shake_practice.R.drawable.smiling_face
import kotlin.math.sqrt

class MainActivity : AppCompatActivity(), SensorEventListener {

    val TAG: String = "로그"

    // 센서매니저
    private lateinit var sensorManager: SensorManager

    private var accel: Float = 0.0f
    private var accelCurrent: Float = 0.0f
    private var accelLast: Float = 0.0f

    private lateinit var x_text: TextView
    private lateinit var y_text: TextView
    private lateinit var z_text: TextView
    private lateinit var face_img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        x_text = findViewById(R.id.x_text)
        y_text = findViewById(R.id.y_text)
        z_text = findViewById(R.id.z_text)
        face_img = findViewById(R.id.face_img)

        // 자료형을 센서매니저로 핸드폰에 있는 서비스를 가져온다.
        this.sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        accel = 10f
        accelCurrent = SensorManager.GRAVITY_EARTH
        accelLast = SensorManager.GRAVITY_EARTH

    }

    override fun onSensorChanged(event: SensorEvent?) {
        // 센서 값이 변경될 때 호출됨
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val x: Float = event.values[0]
            val y: Float = event.values[1]
            val z: Float = event.values[2]

            x_text.text = "X: " + x.toInt().toString()
            y_text.text = "Y: " + y.toInt().toString()
            z_text.text = "Z: " + z.toInt().toString()

            accelLast = accelCurrent
            accelCurrent = sqrt((x * x + y * y + z * z).toDouble().toFloat())

            val delta: Float = accelCurrent - accelLast
            accel = (accel * 0.9 + delta).toFloat()

            if (accel > 30) {
                Toast.makeText(this, "흔들었음", Toast.LENGTH_SHORT).show()
                face_img.setImageResource(smiling_face)

                android.os.Handler(Looper.getMainLooper()).postDelayed({
                    face_img.setImageResource(slightly_smiling_face)
                }, 1000)
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // 센서 정확도가 변경될 때 호출됨
        if (sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val accuracyValue: Float = accuracy.toFloat()

            // 여기에 센서 정확도 처리 코드 추가
        }
    }

    // 일시중지 상태에서 다시 Activity가 활성화 되면 onResume()이 호출됨
    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(
            this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    // 온포즈가 콜되고 나서는 센서가 감지되지 않음
    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}
