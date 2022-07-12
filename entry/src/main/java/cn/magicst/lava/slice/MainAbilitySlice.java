package cn.magicst.lava.slice;

import cn.magicst.lava.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.window.service.WindowManager;
import ohos.bundle.AbilityInfo;
import ohos.global.configuration.Configuration;

/**
 * Full screen ability slice
 */
public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);

        // hide status bar
        this.getWindow().addFlags(WindowManager.LayoutConfig.MARK_ALLOW_EXTEND_LAYOUT);
        this.getWindow().addFlags(WindowManager.LayoutConfig.MARK_FULL_SCREEN);

        // adapt orientation
        int orientation = getResourceManager().getConfiguration().direction;
        if (orientation == Configuration.DIRECTION_HORIZONTAL) {
            super.setUIContent(ResourceTable.Layout_land_main);
        } else {
            super.setUIContent(ResourceTable.Layout_port_main);
        }
    }

    @Override
    protected void onOrientationChanged(AbilityInfo.DisplayOrientation displayOrientation) {
        super.onOrientationChanged(displayOrientation);

        if (displayOrientation == AbilityInfo.DisplayOrientation.LANDSCAPE) {
            setUIContent(ResourceTable.Layout_land_main);
        } else {
            setUIContent(ResourceTable.Layout_port_main);
        }
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
