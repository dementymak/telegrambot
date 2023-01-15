package com.github.dementymak.tb.service;

import com.github.dementymak.tb.javarushclient.dto.GroupDiscussionInfo;
import com.github.dementymak.tb.repository.entity.GroupSub;

/**
 * Service for manipulating with {@link GroupSub}.
 */
public interface GroupSubService {

    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}