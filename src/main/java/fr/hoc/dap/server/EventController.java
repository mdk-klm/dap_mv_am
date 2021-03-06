/**
*
 */
package fr.hoc.dap.server;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.calendar.model.Event;

/**
 * @author house
 *
 */
@RestController
public class EventController {
    /**
     * parametre la configuration du nom, du dossier de destination et des tokens.
     */

    @Autowired
    private CalendarService cldService;

    /**
    *@param nb .
    * @param userKey .
     * @return ce qui doit être afficher sur la page web ici le denrier event de l'utilisateur.
     * @throws GeneralSecurityException .
     * @throws IOException .
    */
    @RequestMapping("/event/next")
    public List<Event> nextEvent(@RequestParam(value = "nb", defaultValue = "1") final Integer nb,
            @RequestParam(value = "userKey") final String userKey) throws IOException, GeneralSecurityException {

        return cldService.calendar(nb, userKey);
    }

    /**
     *@param nb .
     * @param userKey .
      * @return ce qui doit être afficher sur la page web ici le denrier event de l'utilisateur.
      * @throws GeneralSecurityException .
      * @throws IOException .
     */
    @RequestMapping("/event/nextString")
    public String nextEventString(@RequestParam(value = "nb", defaultValue = "1") final Integer nb,
            @RequestParam(value = "userKey") final String userKey) throws IOException, GeneralSecurityException {

        return cldService.retrieveNextEvent(userKey);
    }

    /**
     * .
     */
    @Autowired
    private GmailService gmService;

    /**
     *
     * @param userKey .
     * @return ce qui doit être afficher sur la page web ici le nbr de message non lu de l'utilisateur.
     * @throws IOException If the credentials.json file cannot be found.
     * @throws GeneralSecurityException class is a generic security exception class.
     */
    @RequestMapping("/email/nbunread")
    public Integer unreadEmail(@RequestParam(value = "userKey") final String userKey)
            throws IOException, GeneralSecurityException {

        return gmService.mail(userKey);

    }
}
