import { useContext } from "react";
import { useLocation, Navigate, Outlet } from "react-router-dom";
import { AuthContext } from "@/context/AuthContext";
import TopMenu from "@/components/top-menu";

export function RequireAuth() {
    const { authenticated } = useContext(AuthContext);
    const location = useLocation();

    return authenticated ? (
        <>
            <TopMenu />
            <Outlet />
        </>
    ) : (
        <Navigate to="/login" state={{ from: location }} replace />
    );
}