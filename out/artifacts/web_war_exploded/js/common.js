function shopping_add() {
    if (!confirm("确认要加入购物车吗？")) {
        window.event.returnValue = false;
    }
}
function del() {
    if (!confirm("确认要删除？")) {
        window.event.returnValue = false;
    }
}
function logout() {
    if (!confirm("确认要注销吗？")) {
        window.event.returnValue = false;
    }
}
function nobuy() {
    if (!confirm("确认要移出购物车吗？")) {
        window.event.returnValue = false;
    }
}
function buy() {
    if (!confirm("确认要购买吗？(发货通知可在邮箱查看)")) {
        window.event.returnValue = false;
    }
}