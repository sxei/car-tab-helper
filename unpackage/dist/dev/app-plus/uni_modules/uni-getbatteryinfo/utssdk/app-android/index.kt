package uts.sdk.modules.uniGetbatteryinfo;
import kotlinx.coroutines.async;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import io.dcloud.uts.Map;
import io.dcloud.uts.*;
import android.content.Context;
import android.os.BatteryManager;
import io.dcloud.uts.UTSAndroid;
open class GetBatteryInfoOptions : UTSJSONObject() {
    open var success: UTSCallback? = null;
    open var fail: UTSCallback? = null;
    open var complete: UTSCallback? = null;
}
fun getBatteryInfo(options: GetBatteryInfoOptions) {
    val context = UTSAndroid.getAppContext();
    if (context != null) {
        val manager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager;
        val level = manager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        val res = object : UTSJSONObject() {
            var errCode = 0
            var errSubject = "uni-getBatteryInfo"
            var errMsg = "getBatteryInfo:ok"
            var level = level
            var isCharging = manager.isCharging()
        };
        options.success?.invoke(res);
        options.complete?.invoke(res);
    } else {
        val res1 = object : UTSJSONObject() {
            var errSubject = "uni-getBatteryInfo"
            var errCode = 1001
            var errMsg = "getBatteryInfo:fail getAppContext is null"
        };
        options.fail?.invoke(res1);
        options.complete?.invoke(res1);
    }
}
