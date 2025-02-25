public class HandlerExample {

    public static void start(){

        Request firstRequest = new Request(14, "pc", "school", true);
        Request secondRequest = new Request(22, "mobile", "bachelor", false);
        Request thirdRequest = new Request(24, "tablet", "master", false);
        Request FourRequest = null;


        RequestHandler startHandler;
        RequestHandler trialHandler;
        RequestHandler kidsHandler;
        RequestHandler deviceHandler;
        RequestHandler masterHandler;

        {
            startHandler = new RequestHandler() {
                @Override
                public void handleRequest(Request request) {
                    if(request == null) {
                        System.out.println("Ошибка! Запрос пуст!");
                    } else if (nextHandler != null) {
                        nextHandler.handleRequest(request);
                    }
                }
            };

            trialHandler = new RequestHandler() {
                @Override
                public void handleRequest(Request request) {
                    if (request.getIsTrial()) {
                        System.out.println("Использование сервиса недоступно в пробной версии!");
                    } else if (nextHandler != null) {
                        nextHandler.handleRequest(request);
                    }
                }
            };

            kidsHandler = new RequestHandler() {
                @Override
                public void handleRequest(Request request) {
                    if (request.getAge() < 18) {
                        System.out.println("<загрузка данных для детской версии>");
                    } else if (nextHandler != null) {
                        nextHandler.handleRequest(request);
                    }
                }
            };

            deviceHandler = new RequestHandler() {
                @Override
                public void handleRequest(Request request) {
                    if (request.getDevice() == "mobile") {
                        System.out.println("<загрузка данных для мобильной версии>");
                    } else if (nextHandler != null) {
                        nextHandler.handleRequest(request);
                    }
                }
            };

            masterHandler = new RequestHandler() {
                @Override
                public void handleRequest(Request request) {
                    if (request.getEducationLevel() == "master") {
                        System.out.println("<загрузка данных для продвинутой версии>");
                    } else if (nextHandler != null) {
                        nextHandler.handleRequest(request);
                    }
                }
            };
        }


        startHandler.setNextHandler(trialHandler);
        trialHandler.setNextHandler(kidsHandler);
        kidsHandler.setNextHandler(deviceHandler);
        deviceHandler.setNextHandler(masterHandler);

        startHandler.handleRequest(firstRequest);
        startHandler.handleRequest(secondRequest);
        startHandler.handleRequest(thirdRequest);
        startHandler.handleRequest(FourRequest);
    }
}
