/*
 * Copyright 2015 David Vávra
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.destil.gpsaveraging.ui.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.view.View;

import java.io.Serializable;

/**
 * ViewModel for Main Fragment data binding.
 *
 * @author David Vávra (vavra@avast.com)
 */

public class MainFragmentViewModel implements Serializable {

    public final ObservableBoolean hasFix = new ObservableBoolean();
    public final ObservableField<String> satelliteInfo = new ObservableField<>();
    public final ObservableBoolean isAveraging = new ObservableBoolean();
    public final ObservableBoolean isReadyForSharing = new ObservableBoolean();
    public final ObservableBoolean showAd = new ObservableBoolean();
    private transient FabListener mClickListener;
    public final transient View.OnClickListener onFabClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mClickListener.onFabClicked();
        }
    };

    public void setClickListener(FabListener clickListener) {
        mClickListener = clickListener;
    }

    public interface FabListener {
        void onFabClicked();
    }

    @Override
    public String toString() {
        return "MainFragmentViewModel{" +
                "isReadyForSharing=" + isReadyForSharing.get() +
                ", hasFix=" + hasFix.get() +
                ", satelliteInfo=" + satelliteInfo.get() +
                ", isAveraging=" + isAveraging.get() +
                '}';
    }
}
