package org.example;

import org.example.article.ArticleController;
import org.example.system.SystemController;

public class App {
    ArticleController articleController;
    SystemController systemController;


    App () {
        articleController = new ArticleController();
        systemController = new SystemController();
    }

    public void run () {
        System.out.println("== 게시판 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();

            if (command.equals("종료")) {
                systemController.exit();
                break;
            } else if (command.equals("등록")) {
                articleController.write();
            } else if (command.equals("목록")) {
                articleController.list();
            } else if (command.startsWith("삭제")) {
                articleController.delete(command);
            } else if (command.startsWith("수정")) {
                articleController.modify(command);
            }
        }
    }


}
