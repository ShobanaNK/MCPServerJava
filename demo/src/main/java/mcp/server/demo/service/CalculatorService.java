package mcp.server.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.model.ToolContext;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    @Tool(description = "To perform P(a, n), where the operator P signifies powerof operation.")
    public Double power(ToolContext toolContext, Integer a,
                         @ToolParam(description = "Power value (n) to be used to calculator power operation.") Integer n) {

        String userId = (String)toolContext.getContext().get("userId");
        logger.info(String.format("computing power of %d by %d for %s", a, n, userId));
        return Math.pow(a, (n-1));
    }

}