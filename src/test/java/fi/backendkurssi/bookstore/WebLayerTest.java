package fi.backendkurssi.bookstore;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import fi.backendkurssi.bookstore.domain.BookRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    @Test
    @WithMockUser(username = "user", roles = { "USER" })  // Mock user for routes requiring authentication
    public void testBookList() throws Exception {
        this.mockMvc.perform(get("/booklist")).andDo(print())
                .andExpect(status().isOk());
    }

   @Test
    @WithMockUser(username = "admin", authorities = { "ADMIN" }) // checks whether an admin user can successfully delete a book by sending a request to the /delete/{id} route
    public void testDeleteBook() throws Exception {
        doNothing().when(bookRepository).deleteById(1L);

        mockMvc.perform(get("/delete/1"))
                .andExpect(status().is3xxRedirection());
    }
}