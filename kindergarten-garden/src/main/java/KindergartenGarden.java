import java.util.List;
import java.util.EnumMap;
import java.util.ArrayList;

class KindergartenGarden {
    String garden;
    EnumMap<Student, List<Plant>> studentsPlants = new EnumMap<Student, List<Plant>>(Student.class);

    KindergartenGarden(String garden) {
        this.garden = garden;

        this.init();
    }

    void init() {
        String[] rows = this.garden.split("\n");

        for (int i = 0; i < rows.length; i++) {
            String[] rowParts = rows[i].replaceAll("(\\w{2})", "$1\n").split("\n");

            for (int j = 0; j < rowParts.length; j++) {
                for (int k = 0; k < rowParts[j].length(); k++) {
                    Student student = Student.values()[j];
                    List<Plant> list = studentsPlants.get(student);
                    char plantCode = rowParts[j].charAt(k);

                    if (list == null) list = new ArrayList<>();

                    list.add(Plant.getPlant(plantCode));

                    studentsPlants.put(student, list);
                }
            }
        }
    }

    List<Plant> getPlantsOfStudent(String student) {
        return studentsPlants.get(Student.valueOf(student));
    }

}

enum Student {
    Alice, Bob, Charlie, David,
    Eve, Fred, Ginny, Harriet,
    Ileana, Joseph, Kincaid, Larry;
}

enum Plant {
    VIOLETS,
    RADISHES,
    CLOVER,
    GRASS;

    static Plant getPlant(char plantCode) {
        switch (plantCode) {
            case 'G':
                return GRASS;
            case 'C':
                return CLOVER;
            case 'R':
                return RADISHES;
            case 'V':
                return VIOLETS;
        }

        return null;
    }
}
