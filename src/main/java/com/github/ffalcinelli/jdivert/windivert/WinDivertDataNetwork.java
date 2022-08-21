package com.github.ffalcinelli.jdivert.windivert;

import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinDef;

import java.util.Arrays;
import java.util.List;

public class WinDivertDataNetwork extends Structure {
    public WinDef.UINT ifIdx;
    public WinDef.UINT subIfIdx;

    @Override
    protected List getFieldOrder() {
        return Arrays.asList("ifIdx", "subIfIdx");
    }
}

