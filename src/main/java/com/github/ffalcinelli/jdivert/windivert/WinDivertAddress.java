/*
 * Copyright (c) Fabio Falcinelli 2016.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.ffalcinelli.jdivert.windivert;

import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.platform.win32.WinDef;

import java.util.Arrays;
import java.util.List;

/**
 * Represents the "address" of a captured or injected packet. The address includes the packet's headers interfaces and the packet direction.
 * Created by fabio on 20/10/2016.
 */
public class WinDivertAddress extends Structure {
    public static class WinDivertAddressUnion extends Union {
        public WinDivertDataNetwork network;
        public WinDivertDataFlow flow;
        public WinDivertDataFlow socket;
        public WinDivertDataReflect reflect;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList(
                    "network",
                    "flow",
                    "socket",
                    "reflect");
        }
    }

    public long timestamp;
    public WinDef.ULONG flags;
    public WinDivertAddressUnion union;

    @Override
    protected List getFieldOrder() {
        return Arrays.asList(
                "timestamp",
                "flags",
                "union");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WinDivertAddress that = (WinDivertAddress) o;

        return timestamp == that.timestamp &&
                flags.equals(that.flags);
    }
}