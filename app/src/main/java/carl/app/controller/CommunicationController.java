package carl.app.controller;

import carl.app.dto.TopicPublishDTO;
import carl.app.dto.TopicReplyDTO;
import carl.app.service.CommunicationApplicationService;
import carl.app.vo.PageDetailVO;
import carl.app.vo.PageVO;
import carl.app.vo.TopicVO;
import carl.common.enums.ActionEnum;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className: CommunicationController
 * @description: TODO
 * @author: Carl Tong
 * @date: 2022/4/1 20:41
 */
@RestController
@RequestMapping("/communicate")
public class CommunicationController {

    @Autowired
    CommunicationApplicationService communicationApplicationService;

    @GetMapping("/page")
    public PageVO getPageData(@RequestParam @NonNull Integer pageIndex) {
        return communicationApplicationService.getPageData(pageIndex);
    }

    @GetMapping("/top")
    public List<TopicVO> topList() {
        return communicationApplicationService.topList();
    }

    @GetMapping("/search")
    public List<TopicVO> search(@RequestParam String context) {
        return communicationApplicationService.search(context);
    }

    @GetMapping("/detail/{topicId}")
    @ResponseBody
    public PageDetailVO getTopicDetail(@PathVariable("topicId") Long topicId) {
        return communicationApplicationService.getTopicDetail(topicId);
    }

    @PostMapping("/publish")
    @ResponseBody
    public ActionEnum publish(@RequestBody TopicPublishDTO topicPublishDTO) {
        communicationApplicationService.publish(topicPublishDTO);
        return ActionEnum.SUCCESS;
    }

    @PostMapping("/reply")
    @ResponseBody
    public ActionEnum reply(@RequestBody TopicReplyDTO topicReplyDTO) {
        communicationApplicationService.reply(topicReplyDTO);
        return ActionEnum.SUCCESS;
    }

}
