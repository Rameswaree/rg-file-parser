package com.parser.file.web;

import com.parser.file.service.FileParserService;
import org.springframework.stereotype.Controller;

@Controller
public class FileParserController {

    FileParserService fileParserService;

    public FileParserController(FileParserService fileParserService) {
        this.fileParserService = fileParserService;
    }


}
