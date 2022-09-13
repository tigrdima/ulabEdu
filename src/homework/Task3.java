package homework;

public class Task3 {

    public static boolean fuzzySearch(String template, String fuzzy) {
        boolean rsl = false;
        StringBuilder builder = new StringBuilder();
        int indexCharAtFuzzy = 0;

        for (int i = 0; i < fuzzy.length() && fuzzy.length() >= template.length(); i++) {
            if (template.charAt(indexCharAtFuzzy) == fuzzy.charAt(i)) {
                builder.append(template.charAt(indexCharAtFuzzy++));
                if (builder.toString().equals(template)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println(fuzzySearch("ddddddddddddddd", "ddddddd"));
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
        System.out.println(fuzzySearch("cwhl", "cartwheel"));
        System.out.println(fuzzySearch("cwhee", "cartwheel"));
        System.out.println(fuzzySearch("cartwheel", "cartwheel"));
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));
        System.out.println(fuzzySearch("lw", "cartwheel"));
    }
}
