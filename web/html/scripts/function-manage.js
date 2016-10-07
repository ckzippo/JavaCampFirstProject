// JavaScript Document

// 删除用户
function Delete(id)
{
	if(confirm("确定要删除吗？")) {
		location.href = "/html/manage/delUser?id=" + id;
	}
}

// 删除留言
function DeleteComment(id) {
	if(confirm("确定要删除吗？")) {
		location.href = "/html/manage/delComment?ecid=" + id;
	}
}