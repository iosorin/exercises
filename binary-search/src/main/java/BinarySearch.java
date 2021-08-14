import java.util.List;

class BinarySearch {
    List<Integer> list;

    BinarySearch(List<Integer> list) {
        this.list = list;
    }

    int indexOf(int n) throws ValueNotFoundException {
        int high = list.size() - 1;
        int low = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int candidate = list.get(mid);

            if (candidate == n) return mid;

            if (candidate > n) high = mid - 1;
            if (candidate < n) low = mid + 1;
        }

        throw new ValueNotFoundException("Value not in array");
    }
}