package k15hkii.se114.bookstore.ui.account.address;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import k15hkii.se114.bookstore.data.model.location.*;
import k15hkii.se114.bookstore.utils.SpinnerWrapper;

import java.util.ArrayList;
import java.util.List;

public final class AddressHelper {

    private AddressHelper() {
    }

    public static List<SpinnerWrapper<City>> toWrapper(List<City> cities) {
        List<SpinnerWrapper<City>> wrappers = new ArrayList<>();
        for (City city : cities) {
            wrappers.add(new SpinnerWrapper<City>(city) {
                @Override
                public String getDisplay() {
                    return getItem().getName();
                }
            });
        }
        return wrappers;
    }

    public static void filter(ObservableField<List<SpinnerWrapper<District>>> districts,
                              ObservableField<List<SpinnerWrapper<Ward>>> warps,
                              ObservableField<List<SpinnerWrapper<Project>>> projects,
                              ObservableField<List<SpinnerWrapper<Street>>> streets,
                              ObservableInt districtIndex,
                              ObservableInt warpIndex,
                              ObservableInt projectIndex,
                              ObservableInt streetIndex) {
        District district = districts.get().get(districtIndex.get()).getItem();

        List<SpinnerWrapper<Ward>> warpWrappers = new ArrayList<>();
        for (Ward warp : district.getWards()) {
            warpWrappers.add(new SpinnerWrapper<Ward>(warp) {
                @Override
                public String getDisplay() {
                    return getItem().getPrefix() + " " + getItem().getName();
                }
            });
        }
        int oldWarpIndex = warpIndex.get();
        warps.set(warpWrappers);
        warpIndex.set(Math.min(oldWarpIndex, warpWrappers.size() - 1));

        List<SpinnerWrapper<Project>> projectWrappers = new ArrayList<>();
        for (Project project : district.getProjects()) {
            projectWrappers.add(new SpinnerWrapper<Project>(project) {
                @Override
                public String getDisplay() {
                    return getItem().getName();
                }
            });
        }
        int oldProjectIndex = projectIndex.get();
        projects.set(projectWrappers);
        projectIndex.set(Math.min(oldProjectIndex, projectWrappers.size() - 1));

        List<SpinnerWrapper<Street>> streetWrappers = new ArrayList<>();
        for (Street street : district.getStreets()) {
            streetWrappers.add(new SpinnerWrapper<Street>(street) {
                @Override
                public String getDisplay() {
                    return getItem().getPrefix() + " " + getItem().getName();
                }
            });
        }
        int oldStreetIndex = streetIndex.get();
        streets.set(streetWrappers);
        streetIndex.set(Math.min(oldStreetIndex, streetWrappers.size() - 1));
    }

    public static void filter(ObservableField<List<SpinnerWrapper<City>>> cities,
                              ObservableField<List<SpinnerWrapper<District>>> districts,
                              ObservableField<List<SpinnerWrapper<Ward>>> warps,
                              ObservableField<List<SpinnerWrapper<Project>>> projects,
                              ObservableField<List<SpinnerWrapper<Street>>> streets,
                              ObservableInt cityIndex,
                              ObservableInt districtIndex,
                              ObservableInt warpIndex,
                              ObservableInt projectIndex,
                              ObservableInt streetIndex) {
        City city = cities.get().get(cityIndex.get()).getItem();
        List<SpinnerWrapper<District>> districtWrappers = new ArrayList<>();
        for (District district : city.getDistricts()) {
            districtWrappers.add(new SpinnerWrapper<District>(district) {
                @Override
                public String getDisplay() {
                    return getItem().getName();
                }
            });
        }
        int oldDistrictIndex = districtIndex.get();
        districts.set(districtWrappers);
        districtIndex.set(Math.min(oldDistrictIndex, districtWrappers.size() - 1));

        filter(districts, warps, projects, streets, districtIndex, warpIndex, projectIndex, streetIndex);
    }

}
