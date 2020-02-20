package algorithm.kelvin.app.notification_02

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import java.util.*

fun Context.notificationsManager(message: String?, subtext: String?) {
    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val mBuilder = NotificationCompat.Builder(this, "AlgoKelvin")
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_launcher_background))
        .setContentTitle("AlgoKelvin")
        .setContentText(message)
        .setSubText(subtext)
        .setAutoCancel(true)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel("AlgoKelvin", "AlgoKelvin Notification", NotificationManager.IMPORTANCE_DEFAULT)
        channel.description = message
        mBuilder.setChannelId("AlgoKelvin")
        notificationManager.createNotificationChannel(channel)
    }

    val notification = mBuilder.build()
    notificationManager.notify(Random().nextInt(100), notification)
}