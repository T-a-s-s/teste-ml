package br.com.mercadolivre;

import br.com.mercadolivre.api.advice.ControllerExceptionHandler;
import br.com.mercadolivre.api.exception.ForbiddenException;
import br.com.mercadolivre.api.v1.MutantController;
import br.com.mercadolivre.dto.MutantRequest;
import br.com.mercadolivre.service.MutantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ProjetoMutantesControllerTest {

    private MockMvc mockMvc;

    @MockBean
    MutantService mutantService;

    @Before
    public void initMockMvc() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new MutantController(mutantService))
                .setHandlerExceptionResolvers(createExceptionResolver())
                .build();
    }

    @Test
    public void healthCheckTest() throws Exception {
        mockMvc
                .perform(get("/v1/health"))
                .andExpect(status().isOk());
    }

    @Test
    public void getMutantsTest() throws Exception {
        mockMvc
            .perform(get("/v1/mutants"))
            .andExpect(status().isOk());
    }

    @Test
    public void getStatsTest() throws Exception {
        mockMvc
                .perform(get("/v1/mutants/stats"))
                .andExpect(status().isOk());
    }

    @Test
    public void postMutantDnaTest() throws Exception {
        MutantRequest json = new MutantRequest();
        String [] mutantDna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
        json.setDna(mutantDna);

        mockMvc
            .perform(post("/v1/mutants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(json)))
            .andExpect(status().isOk());
    }

    @Test
    public void postNotMutantDna() {
        MutantRequest json = new MutantRequest();
        String [] notMutantDna = {"ATGCAT", "GATCTA", "TAGGAC", "CCAGCA", "CAGGAC", "ACCACC"};
        json.setDna(notMutantDna);
        when(mutantService.isMutant(any())).thenThrow(ForbiddenException.class);
        try {
            mockMvc
                    .perform(post("/v1/mutants")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(new ObjectMapper().writeValueAsString(json)))
                    .andExpect(status().isForbidden());
        }catch (Exception e) {
            assertTrue(e.getCause() instanceof ForbiddenException);
        }
    }

    protected ExceptionHandlerExceptionResolver createExceptionResolver() {
        ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
            protected ServletInvocableHandlerMethod getExceptionHandlerMethod(HandlerMethod handlerMethod, Exception exception) {
                Method method = new ExceptionHandlerMethodResolver(ControllerExceptionHandler.class).resolveMethod(exception);
                return new ServletInvocableHandlerMethod(new ControllerExceptionHandler(), method);
            }
        };
        exceptionResolver.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        exceptionResolver.afterPropertiesSet();
        return exceptionResolver;
    }

}
