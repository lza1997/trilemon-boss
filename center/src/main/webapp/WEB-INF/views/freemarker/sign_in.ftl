<div>${exMsg}</div>
<form method="POST" action="${requestContext.getContextPath()}/signIn">
    <div>
        <label>redirect：<input type="text" name="redirect" value="${redirect}"/></label>
    </div>
    <div>
        <label>nick：<input type="text" name="nick" value="gymitat"/></label>
    </div>
    <div>
        <label>userId：<input type="text" name="userId" value="56912708"/></label>
    </div>
    <div>
        <label>appKey：<input type="text" name="appKey" value="21685043"/></label>
    </div>
    <div>
        <label>accessToken：<input type="text" name="accessToken"/></label>
    </div>
    <div>
        <label>refreshToken：<input type="text" name="refreshToken"/></label>
    </div>
    <div>
        <input type="submit" value="模拟登录"/>
    </div>
</form>