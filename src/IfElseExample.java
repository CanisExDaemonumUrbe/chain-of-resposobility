public class IfElseExample {

    public static void start() {

        Request firstRequest = new Request(14, "pc", "school", true);
        Request secondRequest = new Request(22, "mobile", "bachelor", false);
        Request thirdRequest = new Request(24, "tablet", "master", false);
        Request FourRequest = null;

        checkRequest(firstRequest);
        checkRequest(secondRequest);
        checkRequest(thirdRequest);
        checkRequest(FourRequest);

    }

    private static void checkRequest(Request request) {
        if (request == null) {
            System.out.println("Ошибка! Запрос пуст!");
        } else if (request.getIsTrial()) {
            System.out.println("Использование сервиса недоступно в пробной версии!");
        } else if (request.getAge() < 18) {
            System.out.println("<загрузка данных для детской версии>");
        } else  if (request.getDevice() == "mobile") {
            System.out.println("<загрузка данных для мобильной версии>");
        } else if (request.getEducationLevel() == "master") {
            System.out.println("<загрузка данных для продвинутой версии>");
        } else {

        }
    }
}
