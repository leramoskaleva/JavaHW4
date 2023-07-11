package HW6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HW6 {
    public static void main(String[] args) {

        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Lenovo", 8, 512, "Windows", "Black"));
        notebooks.add(new Notebook("Dell", 16, 256, "Windows", "Silver"));
        notebooks.add(new Notebook("HP", 8, 256, "Ubuntu", "Black"));
        notebooks.add(new Notebook("Asus", 16, 512, "Windows", "Gold"));
        notebooks.add(new Notebook("Apple", 16, 512, "macOS", "Silver"));
        notebooks.add(new Notebook("Acer", 8, 128, "Windows", "Blue"));

        Map<String, Object> filterCriteria = new HashMap<>();
        filterCriteria.put("ram", 8);
        filterCriteria.put("hddSize", 256);
        filterCriteria.put("os", "Windows");

        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filterCriteria);

        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }

    public static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Object> filterCriteria) {
        Set<Notebook> filteredNotebooks = new HashSet<>();

        for (Notebook notebook : notebooks) {
            boolean passFilter = true;

            for (Map.Entry<String, Object> entry : filterCriteria.entrySet()) {
                String property = entry.getKey();
                Object value = entry.getValue();

                if (property.equals("ram")) {
                    if (notebook.getRam() < (int) value) {
                        passFilter = false;
                        break;
                    }
                } else if (property.equals("hddSize")) {
                    if (notebook.getHddSize() < (int) value) {
                        passFilter = false;
                        break;
                    }
                } else if (property.equals("os")) {
                    if (!notebook.getOs().equals(value)) {
                        passFilter = false;
                        break;
                    }
                }
            }

            if (passFilter) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }
}
