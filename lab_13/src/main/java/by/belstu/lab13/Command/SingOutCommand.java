package by.belstu.lab13.Command;

import by.belstu.lab13.Exceptions.IncorrectDataException;
import by.belstu.lab13.Exceptions.ServiceException;
import by.belstu.lab13.util.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SingOutCommand implements Command {
    private static Logger LOGGER = LogManager.getLogger(SingOutCommand.class);
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException,
            IncorrectDataException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("NAME");
        LOGGER.info("user was above: name:" + username);
        session.removeAttribute("NAME");
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }

}
