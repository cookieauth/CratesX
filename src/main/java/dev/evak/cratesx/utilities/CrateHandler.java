/*
 *
 * Eva K. - https://evak.dev/ - CratesX
 *
 * Created on 4/7/20, 12:01 PM
 * Last Modified on 4/7/20, 12:01 PM
 *
 *     Copyright (C) 2020 Eva K.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package dev.evak.cratesx.utilities;

import dev.evak.cratesx.CratesX;
import dev.evak.cratesx.service.crate.Crate;
import org.bukkit.Location;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CrateHandler {

    private ArrayList<Crate> crates;
    private ArrayList<Location> locations;
    private Boolean newJoinKeys;
    private Boolean overflowKeys;

    private CratesX instance = CratesX.getInstance();

    public CrateHandler() {
        crates = new ArrayList<>();
        locations = new ArrayList<>();
    }

    public ArrayList<Crate> getCrates() {
        return crates;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setCrates(ArrayList<Crate> crates) {
        this.crates = crates;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public Boolean getNewJoinKeys() {
        return newJoinKeys;
    }

    public void setNewJoinKeys(Boolean newJoinKeys) {
        this.newJoinKeys = newJoinKeys;
    }

    public Boolean getOverflowKeys() {
        return overflowKeys;
    }

    public void setOverflowKeys(Boolean overflowKeys) {
        this.overflowKeys = overflowKeys;
    }

    public void loadLocations() {

    }

    public void loadCrates() {
        setNewJoinKeys(false);
        setOverflowKeys(instance.getFileHandler().get(FileType.CONFIG.getName()).getConfig().getBoolean(""));
    }


}
