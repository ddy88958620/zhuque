/*
 * Copyright 2017-2019 The OpenAds Project
 *
 * The OpenAds Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package ai.houyi.zhuque.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ai.houyi.zhuque.auth.service.RoleService;
import ai.houyi.zhuque.commons.page.Page;
import ai.houyi.zhuque.core.model.query.RoleQueryReq;
import ai.houyi.zhuque.dao.RoleMapper;
import ai.houyi.zhuque.dao.UserRoleMapper;
import ai.houyi.zhuque.dao.model.Role;
import ai.houyi.zhuque.dao.model.RoleExample;
import ai.houyi.zhuque.dao.model.UserRoleExample;

/**
 * @author weiping wang
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public void save(Role t) {
		roleMapper.insertSelective(t);
	}

	@Override
	public void update(Role t) {
		roleMapper.updateByPrimaryKeySelective(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer pk) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andRoleIdEqualTo(pk);

		userRoleMapper.deleteByExample(example);
		roleMapper.deleteByPrimaryKey(pk);
	}

	@Override
	public void softDeleteById(Integer pk) {
	}

	@Override
	public Role loadById(Integer pk) {
		return roleMapper.selectByPrimaryKey(pk);
	}

	@Override
	public List<Role> selectAll() {
		return roleMapper.selectByExample(new RoleExample());
	}

	@Override
	public List<Role> selectByQueryReq(RoleQueryReq queryReq) {
		return roleMapper.selectByExample(queryReq.toExample());
	}

	@Override
	public Page<Role> selectPageList(RoleQueryReq queryReq) {
		RoleExample example = queryReq.toExample();

		int total = (int) roleMapper.countByExample(example);
		List<Role> result = roleMapper.selectByExample(example);

		return Page.create(total, queryReq.getPageSize(), result);
	}

}
