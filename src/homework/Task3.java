package homework;

public class Task3 {

    public static boolean fuzzySearch(String template, String fuzzy) {
        StringBuilder builder = new StringBuilder();
        int indexCharAtFuzzy = 0;

        for (int i = 0; i < template.length() && fuzzy.length() >= template.length(); i++) {
            for (int j = indexCharAtFuzzy; j < fuzzy.length(); j++) {
                if (template.charAt(i) == fuzzy.charAt(j)) {
                    builder.append(template.charAt(i));
                    indexCharAtFuzzy++;
                    break;
                }
                indexCharAtFuzzy++;
            }
        }
        return builder.toString().equals(template);
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
