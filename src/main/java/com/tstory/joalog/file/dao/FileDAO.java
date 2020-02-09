package com.tstory.joalog.file.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.tstory.joalog.post.dao.Post;

@Repository("FileDAO")
public class FileDAO {
	
	@Inject
	private SqlSessionTemplate sqlSession;	
	
	public void insertFileInfo(FileInfo fileInfo) {
		sqlSession.insert("file.insertFileInfo", fileInfo);
	}
	
	public boolean insertGroupId(String groupId) {
		try {
			sqlSession.insert("file.insertGroupInfo", groupId);
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<FileInfo> selectFileInfos(FileInfo fileInfo) {
		return sqlSession.selectList("file.selectFileInfos", fileInfo);
	}
	
	public FileInfo selectFileInfo(FileInfo fileInfo) {
		return sqlSession.selectOne("file.selectFileInfo", fileInfo);
	}
	
	public void updateFilePathCount(String groupId) {
		sqlSession.update("file.increaseFilePathCount", groupId);
	}

	public void deleteFile(FileInfo fileInfo) {
		System.out.println(fileInfo);
		sqlSession.update("file.decreaseFilePathCount", fileInfo);
		sqlSession.delete("file.deleteFileInfo", fileInfo);
	}
	
	
}
